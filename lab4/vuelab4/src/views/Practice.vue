<template>
    <div class="gamePage">
        <div class="practiceGrid">
            <div class="grid--exit">
                <router-link to="MainMenu" class="exitButton">Main Menu</router-link>
            </div>
            <div class="grid--graph flexColumn">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 400 400">
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
        name: "Practice",
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
            resultsAdd: function ({ r, x, y }) {
                this.results.push({ r, x, y, figura: true, time: 'h' });
            },
            resultsRemove: function () {
                this.results = [];
            }
        }
    }
</script>

<style>
    .gamePage {
        font-family: 'Exo', monospace;
        background: url('../assets/gamePage.svg') no-repeat fixed center center;
        background-size: cover;
    }

    .flexColumn {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

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
        padding: 10px 20px;
        height: 100vh;
        grid-row-gap: 40px;
        grid-column-gap: 20px;
        grid: [row1-start] "exit nothing1 nothing2 nothing3" auto [row1-end]
        [row2-start] "nothing0 graph graphPanel nothing3" calc(30vh + 100px) [row2-end]
        [row3-start] "nothing0 graphTable graphTable nothing3" auto [row3-end];
        grid-template-columns: 6fr 10fr 10fr 6fr;
        box-sizing: border-box;
    }

    .exitButton:hover {
        cursor: pointer;
        text-decoration: underline;
    }

    .grid--graph {
        grid-area: graph;
        user-select: none;
    }
</style>