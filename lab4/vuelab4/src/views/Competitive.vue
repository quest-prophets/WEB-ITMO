<template>
    <div class="gamePage">
        <div class="competitiveGrid">
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
                        <g stroke="white" stroke-width="1px" stroke-dasharray="10">
                            <path id="xRuler" d=""></path>
                            <path id="yRuler" d=""></path>
                        </g>
                        <g id="graphDots"></g>
                    </svg>
                </div>
                <div class="flexColumn">
                    <Suspect style="grid-area: suspect1"
                             :ids="{path1id: 'suspect1--path1', path2id: 'suspect1--path2',path3id: 'suspect1--path3',path4id: 'suspect1--path4'}"/>
                </div>
                <div class="flexColumn">
                    <Suspect style="grid-area: suspect2"
                             :ids="{path1id: 'suspect2--path1', path2id: 'suspect2--path2',path3id: 'suspect2--path3',path4id: 'suspect2--path4'}"/>
                </div>
                <div class="flexColumn">
                    <Suspect style="grid-area: suspect3"
                             :ids="{path1id: 'suspect3--path1', path2id: 'suspect3--path2',path3id: 'suspect3--path3',path4id: 'suspect3--path4'}"/>
                </div>
                <div class="flexColumn">
                    <Suspect style="grid-area: suspect4"
                             :ids="{path1id: 'suspect4--path1', path2id: 'suspect4--path2',path3id: 'suspect4--path3',path4id: 'suspect4--path4'}"/>
                </div>
                <div class="flexColumn">
                    <Suspect style="grid-area: suspect5"
                             :ids="{path1id: 'suspect5--path1', path2id: 'suspect5--path2',path3id: 'suspect5--path3',path4id: 'suspect5--path4'}"/>
                </div>
                <div class="flexColumn">
                    <Suspect style="grid-area: suspect6"
                             :ids="{path1id: 'suspect6--path1', path2id: 'suspect6--path2',path3id: 'suspect6--path3',path4id: 'suspect6--path4'}"/>
                </div>
            </div>
            <ClockPanel id="graphPanel" @start-game="startGame"/>
        </div>
    </div>
</template>

<script>
    import ClockPanel from "../components/ClockPanel";
    import Suspect from "../components/Suspect";

    export default {
        name: "competitive",
        components: {Suspect, ClockPanel},
        methods: {
            startGame: function () {

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
    }

    .grid--graphMain {
        grid-area: graphMain;
    }

    .graphMain:hover {
        cursor: url("../assets/aim.svg") 16 16, pointer;
    }

    @media (max-width: 1400px) {
        .grid--graph {
            width: 70%;
        }
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