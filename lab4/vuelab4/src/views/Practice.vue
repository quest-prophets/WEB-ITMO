<template>
    <div class="gamePage">
        <div class="practiceGrid" v-if="result == null">
            <div class="grid--exit">
                <router-link to="MainMenu" class="exitButton">
                    Main Menu
                </router-link>
            </div>

            <div class="grid--graph">
                <div class="flexColumn grid--graphMain">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 400 400" class="graphMain">
                        <g stroke="white" stroke-width="2px">
                            <path d="M 0 200 h 400"></path>
                            <path d="M 200 0 v 400"></path>
                            <path d="M 200 0 l -4 7"></path>
                            <path d="M 200 0 l 4 7"></path>
                            <path d="M 400 200 l -7 -4"></path>
                            <path d="M 400 200 l -7 4"></path>
                            <path d="M 0 0 h 50"></path>
                            <path d="M 0 0 v 50"></path>
                            <path d="M 400 0 h -50"></path>
                            <path d="M 400 0 v 50"></path>
                            <path d="M 0 400 h 50"></path>
                            <path d="M 0 400 v -50"></path>
                            <path d="M 400 400 h -50"></path>
                            <path d="M 400 400 v -50"></path>
                        </g>
                        <g id="graphDots"></g>
                    </svg>
                </div>
                <div class="flexColumn" v-for="(graph, i) in suspectGraphs" :key="i">
                    <Suspect :style="{ gridArea: `suspect${i}` }" :graph="graph" @click.native="chooseSuspect(graph)"/>
                </div>
            </div>
            <HelpPanel id="graphPanel"/>
        </div>
        <div v-else>
            {{result}}
        </div>
    </div>
</template>

<script>
    import HelpPanel from "../components/HelpPanel";
    import Suspect from "../components/Suspect";
    import {postStartPractice, postFinishPractice} from "../api";

    export default {
        name: "Practice",
        components: {Suspect, HelpPanel},
        data() {
            return {
                suspectGraphs: [],
                result: null
            };
        },
        async mounted() {
            const {suspectTypes, checkedDots} = await postStartPractice();
            this.suspectGraphs = suspectTypes;
            if (checkedDots == null) return;
            checkedDots.forEach(dot => {
                this.addDot(dot.x, dot.y, dot.isHit)
            });
        },
        methods: {
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
                    cross.setAttributeNS(null, 'd', 'M ' + graphX - 3 + " " + graphY - 3 + " l 6 6 M " + graphX + 3 + " " + graphY - 3 + " l -6 6");
                    document.getElementById("graphDots").appendChild(cross);
                }
            },
            async chooseSuspect(graph) {
                const response = await postFinishPractice(graph);
                this.result = await response.json()
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

    .practiceGrid {
        display: grid;
        padding: 10px 20px 30vh;
        height: 100vh;
        grid-column-gap: 20px;
        grid: "exit exit exit exit" 50px "nothingL graphAndSuspects graphPanel nothingR" auto;
        grid-template-columns: 3fr 10fr 5fr 3fr;
        box-sizing: border-box;
    }

    .exitButton:hover {
        cursor: pointer;
        text-decoration: underline;
    }

    .grid--graph {
        display: grid;
        grid-area: graphAndSuspects;
        user-select: none;
        grid: "suspect1 graphMain suspect2" "suspect3 graphMain suspect4" "suspect5 graphMain suspect6";
        grid-column-gap: 20px;
        grid-template-columns: 10fr 35fr 10fr;
        background: rgba(0, 0, 0, 0.6);
        box-shadow: 0 0 10px 10px rgba(0, 0, 0, 0.6);
    }

    .grid--graphMain {
        grid-area: graphMain;
    }

    .graphMain:hover {
        cursor: url("../assets/aim.svg") 16 16, pointer;
    }

    @media (max-width: 1400px) {
        .practiceGrid {
            grid-template-columns: 1fr 10fr 5fr 1fr;
        }
    }

    @media (max-width: 1000px) {
        .practiceGrid {
            grid-template-columns: 0 10fr 5fr 0;
        }
    }

    @media (max-width: 800px) {
        .practiceGrid {
            grid: "exit" 40px "graphAndSuspects" auto "graphPanel" auto;
            grid-row-gap: 30px;
            grid-template-columns: 1fr;
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

        .grid--graph {
            grid: "suspect1 graphMain suspect2" "suspect3 graphMain suspect4" "suspect5 graphMain suspect6";
            grid-row-gap: 20px;
            grid-template-columns: 5fr 14fr 5fr;
            grid-template-rows: 1fr 1fr 1fr;
        }
    }

    @media (max-width: 500px) {
        .grid--graph {
            width: 90%;
            margin: 0 auto;
        }

        .practiceGrid {
            grid-row-gap: 10px;
            padding: 10px 10px;
        }

        .grid--graph {
            grid: "suspect1 suspect2 suspect3" "graphMain graphMain graphMain" "suspect4 suspect5 suspect6";
        }
    }
</style>