<template>
    <div class="gamePage">
        <div class="competitiveGrid" v-if="result == null">
            <div class="grid--exit">
                <router-link to="MainMenu" class="exitButton">
                    Main Menu
                </router-link>
            </div>
            <div class="grid--graph">
                <div class="flexColumn grid--graphMain">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 400 400" class="graphMain" id="mainGraph"
                         @click="addFromGraph">
                        <g stroke="white" stroke-width="2px">
                            <!-- axis -->
                            <path d="M 0 200 h 400"></path>
                            <path d="M 200 0 v 400"></path>
                            <!-- arrows -->
                            <path d="M 200 0 l -4 7"></path>
                            <path d="M 200 0 l 4 7"></path>
                            <path d="M 400 200 l -7 -4"></path>
                            <path d="M 400 200 l -7 4"></path>
                            <!-- frame -->
                            <path d="M 0 0 h 50"></path>
                            <path d="M 0 0 v 50"></path>
                            <path d="M 400 0 h -50"></path>
                            <path d="M 400 0 v 50"></path>
                            <path d="M 0 400 h 50"></path>
                            <path d="M 0 400 v -50"></path>
                            <path d="M 400 400 h -50"></path>
                            <path d="M 400 400 v -50"></path>
                            <!-- markup -->
                            <path d="M 40 190 v 20"></path>
                            <path d="M 360 190 v 20"></path>
                            <path d="M 190 40 h 20"></path>
                            <path d="M 190 360 h 20"></path>
                            <path d="M 120 195 v 10"></path>
                            <path d="M 280 195 v 10"></path>
                            <path d="M 195 120 h 10"></path>
                            <path d="M 195 280 h 10"></path>
                        </g>
                        <g id="graphDots"></g>
                    </svg>
                </div>
                <div class="flexColumn" v-for="(graph, i) in suspectGraphs" :key="i">
                    <Suspect :style="{ gridArea: `suspect${i}` }" :graph="graph" :clickable="true"
                             @click.native="chooseSuspect(graph)"/>
                </div>
            </div>
            <ClockPanel id="graphPanel" @start-game="startGame"/>
        </div>
        <div v-else class="result flexColumn">
            <div v-if="result.success === true">Success!</div>
            <div v-else>Failure</div>
            <div>Time: {{result.elapsedTime}}</div>
            <div>Clicks: {{result.clicks}}</div>
            <div>Score: {{result.gameScore}}</div>
            <div style="margin-top: 20px">Your answer:</div>
            <Suspect :graph="clickedGraph" :clickable="false" class="resultSuspects"/>
            <div style="margin-top: 20px;" v-if="result.success === false">True answer:</div>
            <Suspect :graph="result.trueGraph" v-if="result.success === false" :clickable="false"
                     class="resultSuspects"/>
            <button class="bwButton bwButton-blackBackground resultButton" @click="restartGame">Retry
            </button>
            <router-link to="MainMenu" class="bwButton bwButton-blackBackground resultButton">Main Menu</router-link>
        </div>
    </div>
</template>

<script>
    import ClockPanel from "../components/ClockPanel";
    import Suspect from "../components/Suspect";
    import {postStartCompetitive, postSetCompetitiveDot, postFinishCompetitive} from "../api";

    export default {
        name: "competitive",
        components: {Suspect, ClockPanel},
        data() {
            return {
                suspectGraphs: null,
                result: null,
                clickedGraph: null
            };
        },
        methods: {
            async startGame() {
                const {suspectTypes, checkedDots} = await postStartCompetitive();
                this.suspectGraphs = suspectTypes;
                if (checkedDots == null) return;
                checkedDots.forEach(dot => {
                    this.addDot(dot.x, dot.y, dot.hit)
                });
            },
            async restartGame() {
                this.result = null;
                const {suspectTypes} = await postStartCompetitive();
                this.suspectGraphs = suspectTypes;
            },
            async addFromGraph(e) {
                if (this.suspectGraphs !== null) {
                    const x = (e.clientX - document.getElementById("mainGraph").getBoundingClientRect().left - 200) / 160;
                    const y = -(e.clientY - document.getElementById("mainGraph").getBoundingClientRect().top - 200) / 160;
                    const response = await postSetCompetitiveDot(parseFloat(x), parseFloat(y));
                    await this.addDot(response.x, response.y, response.figura);
                }
            },
            async addDot(x, y, figura) {
                const graphX = x * 160 + 200;
                const graphY = -y * 160 + 200;
                if (figura) {
                    const circle = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
                    circle.setAttributeNS(null, 'cx', graphX);
                    circle.setAttributeNS(null, 'cy', graphY);
                    circle.setAttributeNS(null, 'r', '3');
                    circle.setAttributeNS(null, 'style', 'fill: black; stroke: white; stroke-width: 1px;');
                    document.getElementById("graphDots").appendChild(circle);
                } else {
                    const cross = document.createElementNS("http://www.w3.org/2000/svg", 'path');
                    cross.setAttributeNS(null, 'stroke', "white");
                    cross.setAttributeNS(null, 'd', 'M ' + (graphX - 3) + " " + (graphY - 3) + " l 6 6 M " + (graphX + 3) + " " + (graphY - 3) + " l -6 6");
                    document.getElementById("graphDots").appendChild(cross);
                }
            },
            async chooseSuspect(graph) {
                const response = await postFinishCompetitive(graph);
                this.clickedGraph = graph;
                this.result = await response.json();
                this.result.elapsedTime = await this.msToTime(this.result.elapsedTime);
            },
            async msToTime(msTime) {
                const ms = msTime % 1000;
                msTime = (msTime - ms) / 1000;
                const s = msTime % 60;
                msTime = (msTime - s) / 60;
                const mins = msTime % 60;
                const hrs = (msTime - mins) / 60;
                return hrs + ' : ' + mins + ' : ' + s + ' . ' + ms;
            }
        }
    }
</script>

<style scoped>
    .grid--exit {
        grid-area: exit;
    }

    .exitButton {
        text-decoration: none;
        color: white;
        font-size: 20px;
    }

    .competitiveGrid {
        display: grid;
        height: 100vh;
        grid-column-gap: 20px;
        padding: 10px 20px;
        grid: "exit" 40px "graphAndSuspects" auto "graphPanel" auto;
        grid-row-gap: 30px;
        grid-template-columns: 1fr;
        box-sizing: border-box;
    }

    .exitButton:hover {
        cursor: pointer;
        text-decoration: underline;
    }

    .grid--graph {
        width: 50%;
        margin: 0 auto;
        display: grid;
        grid-area: graphAndSuspects;
        user-select: none;
        grid: "suspect1 graphMain suspect2" "suspect3 graphMain suspect4" "suspect5 graphMain suspect6";
        grid-row-gap: 20px;
        grid-template-columns: 5fr 14fr 5fr;
        grid-template-rows: 1fr 1fr 1fr;
        grid-column-gap: 20px;
        background: rgba(0, 0, 0, 0.6);
        box-shadow: 0 0 10px 10px rgba(0, 0, 0, 0.6);
    }

    .grid--graphMain {
        grid-area: graphMain;
    }

    .graphMain:hover {
        cursor: url("../assets/aim.svg") 16 16, pointer;
    }

    .result {
        color: white;
        margin-top: 40px;
        font-size: 18px;
    }

    .resultButton {
        font-size: 18px;
        margin-top: 15px;
    }

    .resultSuspects {
        max-width: 300px;
    }

    @media (max-width: 1400px) {
        .grid--graph {
            width: 70%;
        }
    }

    @media (max-width: 800px) {
        .grid--graph {
            width: 90%;
            grid-template-columns: 5fr 16fr 5fr;
        }

        .exitButton {
            font-size: 25px;
            border: 2px solid white;
            padding: 3px 15px;
        }

        .exitButton:hover {
            text-decoration: none;
            color: black;
            background: white;
        }
    }

    @media (max-width: 700px) {
        .grid--graph {
            width: 95%;
        }
    }

    @media (max-width: 590px) {
        .grid--graph {
            width: 85%;
        }

        .competitiveGrid {
            grid-row-gap: 10px;
            padding: 10px 10px;
        }

        .grid--graph {
            grid: "suspect1 suspect2 suspect3" "graphMain graphMain graphMain" "suspect4 suspect5 suspect6";
        }
    }

    @media (max-width: 500px) {
        .grid--graph {
            width: 90%;
        }
    }
</style>