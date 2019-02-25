<template>
    <div class="gamePage">
        <div class="labGrid">
            <div class="grid--exit">
                <router-link to="MainMenu" class="exitButton">
                    Main Menu
                </router-link>
            </div>
            <div class="grid--graph flexColumn">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 400 400" class="mainPracticeGraph">
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
                    <path stroke="white" fill="white" d="M 200 200 h -160 v -80 h 160 Z"></path>
                    <path stroke="white" fill="white" d="M 200 200 v -80 q 80 0 80 80 Z"></path>
                    <path stroke="white" fill="white" d="M 200 200 v 80 l -160 -80 Z"></path>

                    <path stroke="black" stroke-width="2px" d="M 200 200 h -160"></path>
                    <path stroke="black" stroke-width="2px" d="M 200 200 h 80"></path>
                    <path stroke="black" stroke-width="2px" d="M 200 200 v 80"></path>
                    <path stroke="black" stroke-width="2px" d="M 200 200 v -80"></path>

                    <text stroke="white" fill="white" font-size="22px" x="32" y="225">R</text>
                    <text stroke="white" fill="white" font-size="22px" x="265" y="225">R/2</text>
                    <text stroke="white" fill="white" font-size="22px" x="150" y="110">R/2</text>
                    <text stroke="white" fill="white" font-size="22px" x="210" y="285">R/2</text>
                </svg>
            </div>
            <GraphPanel @add-data="resultsAdd" @erase-data="resultsRemove"/>
            <PaperTable :results="results"/>
        </div>
    </div>
</template>

<script>
    import PaperTable from "../components/PaperTable";
    import GraphPanel from "../components/GraphPanel";

    export default {
        name: "LabMode",
        components: {GraphPanel, PaperTable},
        data: function () {
            return {
                results: [
                    {r: 1, x: 2, y: 11, figura: true, time: "11:22:33"},
                    {r: 4, x: 21, y: 64, figura: false, time: "20:00:00"},
                    {r: 8, x: 8, y: 81, figura: true, time: "88:22:33"}
                ]
            }
        },
        methods: {
            resultsAdd: function ({r, x, y}) {
                this.results.push({r, x, y, figura: true, time: 'h'});
            },
            resultsRemove: function () {
                this.results = [];
            }
        }
    }
</script>

<style scoped>
    .labGrid {
        display: grid;
        padding: 10px 20px;
        height: 100vh;
        grid-row-gap: 40px;
        grid-column-gap: 20px;
        grid: "exit nothing1 nothing2 nothing3" auto "nothing0 graph graphPanel nothing3" calc(30vh + 100px) "graphTable graphTable graphTable graphTable" auto;
        grid-template-columns: 6fr 10fr 10fr 6fr;
        box-sizing: border-box;
    }

    .exitButton {
        text-decoration: none;
        color: white;
        font-size: 20px;
    }

    .exitButton:hover {
        cursor: pointer;
        text-decoration: underline;
    }

    .grid--graph {
        grid-area: graph;
        user-select: none;
    }

    .grid--exit {
        grid-area: exit;
    }

    .mainPracticeGraph {
        cursor: pointer;
    }

    @media (max-width: 1200px) {
        .labGrid {
            grid: "exit exit nothing2 nothing3" auto "nothing0 graph graphPanel nothing3" calc(30vh + 100px) "graphTable graphTable graphTable graphTable" auto;
            grid-template-columns: 2fr 7fr 7fr 1fr;
            grid-column-gap: 15px;
            grid-row-gap: 30px;
        }

        .grid--exit {
            text-align: left;
            margin-top: 10px;
        }

        .exitButton {
            font-size: 25px;
        }
    }

    @media (max-width: 1055px) {
        .labGrid {
            grid: "exit exit nothing2 nothing3" auto "nothing0 graph graphPanel nothing3" calc(30vh + 100px) "graphTable graphTable graphTable graphTable" auto;
            grid-template-columns: 0.5fr 7fr 4fr 0.5fr;
            grid-column-gap: 30px;
            grid-row-gap: 30px;
        }

        .grid--exit {
            text-align: left;
            margin-top: 10px;
        }

        .exitButton {
            font-size: 25px;
        }
    }

    @media (max-width: 850px) {
        .labGrid {
            grid-template-rows: 50px calc(35vh + 100px) auto;
            grid-column-gap: 20px;
            grid-row-gap: 20px;
            grid-template-columns: 0 10fr 7fr 0;
        }

        .exitButton {
            font-size: 25px;
            border: 2px solid white;
            padding: 3px 15px;
        }

        .exitButton:hover{
            text-decoration: none;
            color: black;
            background: white;
        }
    }

    @media (max-width: 700px) {
        .labGrid {
            grid: "exit" auto "graph" calc(30vh + 100px) "graphPanel" auto "graphTable" auto;
            grid-row-gap: 15px;
            grid-column-gap: 0;
            padding: 0;
            grid-template-columns: 1fr;
        }
    }

    @media (max-width: 420px) {
        .labGrid {
            grid: "exit" auto "graph" calc(25vh + 100px) "graphPanel" auto "graphTable" auto;
        }
    }

    @media (max-width: 380px) {
        .labGrid {
            grid: "exit" auto "graph" calc(25vh) "graphPanel" auto "graphTable" auto;
        }
    }
</style>