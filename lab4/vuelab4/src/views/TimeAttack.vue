<template>
    <div class="gamePage">
        <div class="timeGrid">
            <div class="grid--exit">
                <router-link to="MainMenu" class="exitButton">Main Menu</router-link>
            </div>
            <div class="grid--suspects">
                <div class="suspectsGrid">
                    <Suspect style="grid-area: suspect1"
                             :ids="{path1id: 'suspect1--path1', path2id: 'suspect1--path2',path3id: 'suspect1--path3',path4id: 'suspect1--path4'}"/>
                    <Suspect style="grid-area: suspect2"
                             :ids="{path1id: 'suspect2--path1', path2id: 'suspect2--path2',path3id: 'suspect2--path3',path4id: 'suspect2--path4'}"/>
                    <Suspect style="grid-area: suspect3"
                             :ids="{path1id: 'suspect3--path1', path2id: 'suspect3--path2',path3id: 'suspect3--path3',path4id: 'suspect3--path4'}"/>
                    <Suspect style="grid-area: suspect4"
                             :ids="{path1id: 'suspect4--path1', path2id: 'suspect4--path2',path3id: 'suspect4--path3',path4id: 'suspect4--path4'}"/>
                    <Suspect style="grid-area: suspect5"
                             :ids="{path1id: 'suspect5--path1', path2id: 'suspect5--path2',path3id: 'suspect5--path3',path4id: 'suspect5--path4'}"/>
                    <Suspect style="grid-area: suspect6"
                             :ids="{path1id: 'suspect6--path1', path2id: 'suspect6--path2',path3id: 'suspect6--path3',path4id: 'suspect6--path4'}"/>
                </div>
            </div>
            <div class="grid--leaderboard">
                <table class="leaderboardTable">
                    <thead>
                    <tr>
                        <td>
                            Position
                        </td>
                        <td>
                            Name
                        </td>
                        <td>
                            Time
                        </td>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
            <div class="grid--graph flexColumn">
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
            <ClockPanel @start-game="startGame"/>
            <NoRTable :results="results"/>
        </div>
    </div>
</template>

<script>
    import NoRTable from "../components/NoRTable";
    import ClockPanel from "../components/ClockPanel";
    import Suspect from "../components/Suspect";

    export default {
        name: "TimeAttack",
        components: {Suspect, ClockPanel, NoRTable},
        data: function () {
            return {
                results: [
                    {x: 2, y: 11, figura: true, time: "11:22:33"},
                    {x: 21, y: 64, figura: false, time: "20:00:00"},
                    {x: 8, y: 81, figura: true, time: "88:22:33"}
                ]
            }
        },
        methods: {
            resultsAdd: function ({r, x, y}) {
                this.results.push({r, x, y, figura: true, time: 'h'});
            },
            resultsRemove: function () {
                this.results = [];
            },
            startGame: function () {

            }
        }
    }
</script>

<style scoped>
    .grid--exit {
        grid-area: exit;
    }

    .grid--leaderboard {
        grid-area: leaderboard;
        border-radius: 10px;
        background: rgba(255, 255, 255, 0.96);
        width: 90%;
        margin: 0 auto;
        height: 90%;
    }

    .leaderboardTable{
        width: 100%;
    }

    table {
        margin: 0 auto;
        border-collapse: collapse;
    }

    thead {
        border-bottom: 2px solid black;
    }

    td {
        padding: 4px 7px;
        border-right: 2px solid black;
    }

    td:last-child {
        border: none;
    }

    .exitButton {
        text-decoration: none;
        color: white;
        font-size: 20px;
    }

    .grid--suspects {
        grid-area: suspects;
    }

    .suspectsGrid {
        display: grid;
        grid: [row1-start] "suspect1 suspect2" [row1-end] [row2-start] "suspect3 suspect4" [row2-end] [row3-start] "suspect5 suspect6" [row3-end];
        height: 100%;
        grid-column-gap: 10px;
        grid-row-gap: 10px;
    }

    .timeGrid {
        display: grid;
        padding: 10px 20px;
        height: 100vh;
        grid-row-gap: 40px;
        grid-column-gap: 20px;
        grid: [row1-start] "exit nothing1 nothing2 nothing3" auto [row1-end] [row2-start] "suspects graph graphPanel leaderboard" calc(30vh + 100px) [row2-end] [row3-start] "suspects graphTable graphTable leaderboard" auto [row3-end] [row3-start] "nothing0 graphTable graphTable nothing4" auto [row3-end];
        grid-template-columns: 9fr 10fr 7fr 11fr;
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

    .graphMain:hover{
        cursor: url("../assets/aim.svg") 16 16, pointer;
    }
</style>