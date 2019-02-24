<template>
    <div class="gamePage">
        <div class="detectiveGrid" id="mainGrid">
            <div class="grid--exit">
                <router-link to="MainMenu" class="exitButton">
                    <span class="exitLabel1">
                        Main Menu
                    </span>
                    <span class="exitLabel2">
                        Menu
                    </span>
                </router-link>
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
                            Shots
                        </td>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
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
            <NoRPanel id="graphPanel" @start-game="startGame" @add-data="resultsAdd" @erase-data="resultsRemove"/>
            <NoRTable id="paperTable" :results="results"/>
            <div class="grid--mobileButtonLeft" @click="leftButtonChange">
            <span class="mobileButtonLeft">
                History
            </span>
            </div>
            <div class="grid--mobileButtonRight" @click="rightButtonChange">
            <span class="mobileButtonRight">
                Leaderboard
            </span>
            </div>
        </div>
    </div>
</template>

<script>
    import NoRTable from "../components/NoRTable";
    import NoRPanel from "../components/NoRPanel";
    import Suspect from "../components/Suspect";

    export default {
        name: "Detective",
        components: {Suspect, NoRPanel, NoRTable},
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

            },
            leftButtonChange: function (e) {
                if (document.getElementById("paperTable").style.display === "none" || document.getElementById("paperTable").style.display === "") {
                    document.getElementsByClassName("grid--graph")[0].style.display = "none";
                    document.getElementById("graphPanel").style.display = "none";
                    document.getElementsByClassName("grid--leaderboard")[0].style.display = "none";
                    document.getElementById("paperTable").style.display = "block";
                    document.getElementById("mainGrid").style.grid = "'buttonLeft exit buttonRight' 40px 'graphTable graphTable graphTable' auto";
                    e.target.innerHTML = "Figura";
                    document.getElementsByClassName("mobileButtonRight")[0].innerHTML = "Leaderboard"
                } else {
                    document.getElementsByClassName("grid--graph")[0].style.display = "grid";
                    document.getElementById("graphPanel").style.display = "block";
                    document.getElementById("paperTable").style.display = "none";
                    document.getElementById("mainGrid").style.grid = "'buttonLeft exit buttonRight' 40px 'graphAndSuspects graphAndSuspects graphAndSuspects' auto 'graphPanel graphPanel graphPanel' auto";
                    e.target.innerHTML = "History"
                }
            },
            rightButtonChange: function (e) {
                if (document.getElementsByClassName("grid--leaderboard")[0].style.display === "none" || document.getElementsByClassName("grid--leaderboard")[0].style.display === "") {
                    document.getElementsByClassName("grid--graph")[0].style.display = "none";
                    document.getElementById("graphPanel").style.display = "none";
                    document.getElementById("paperTable").style.display = "none";
                    document.getElementsByClassName("grid--leaderboard")[0].style.display = "block";
                    document.getElementById("mainGrid").style.grid = "'buttonLeft exit buttonRight' 40px 'leaderboard leaderboard leaderboard' auto";
                    e.target.innerHTML = "Figura";
                    document.getElementsByClassName("mobileButtonLeft")[0].innerHTML = "History"
                } else {
                    document.getElementsByClassName("grid--graph")[0].style.display = "grid";
                    document.getElementById("graphPanel").style.display = "block";
                    document.getElementsByClassName("grid--leaderboard")[0].style.display = "none";
                    document.getElementById("mainGrid").style.grid = "'buttonLeft exit buttonRight' 40px 'graphAndSuspects graphAndSuspects graphAndSuspects' auto 'graphPanel graphPanel graphPanel' auto";
                    e.target.innerHTML = "Leaderboard"
                }
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

    .leaderboardTable {
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

    .exitLabel2 {
        display: none;
    }

    .detectiveGrid {
        display: grid;
        padding: 10px 20px;
        height: 100vh;
        grid-row-gap: 40px;
        grid-column-gap: 20px;
        grid: "exit exit exit exit" 50px "nothing8 graphAndSuspects graphPanel leaderboard" auto "graphTable graphTable graphTable graphTable" auto;
        grid-template-columns: 3fr 10fr 5fr 6fr;
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
        grid-row-gap: 20px;
        grid-column-gap: 20px;
        grid-template-columns: 10fr 35fr 10fr;
    }

    .grid--graphMain {
        grid-area: graphMain;
    }

    .graphMain:hover {
        cursor: url("../assets/aim.svg") 16 16, pointer;
    }

    .mobileButtonLeft, .mobileButtonRight {
        display: none;
        color: white;
        font-size: 25px;
        border: 2px solid white;
        border-radius: 5px;
        padding: 8px;
        cursor: pointer;
        user-select: none;
    }

    .mobileButtonLeft:hover, .mobileButtonRight:hover {
        text-decoration: underline;
    }

    .grid--mobileButtonLeft {
        grid-area: buttonLeft;
        text-align: center;
    }

    .grid--mobileButtonRight {
        grid-area: buttonRight;
        text-align: center;
    }

    @media (max-width: 1300px) {
        .detectiveGrid {
            grid-template-columns: 1fr 10fr 5fr 6fr;
        }
    }

    @media (max-width: 1100px) {
        .detectiveGrid {
            grid: "exit exit exit exit" 40px "nothing8 graphPanel graphAndSuspects leaderboard" auto "graphTable graphTable graphTable graphTable" auto;
            grid-row-gap: 0;
            grid-template-columns: 0 4fr 4.5fr 4fr;
        }

        .grid--graph {
            grid: "suspect1 suspect2 suspect3" "graphMain graphMain graphMain" "suspect4 suspect5 suspect6";
            grid-template-columns: 10fr 10fr 10fr;
            grid-template-rows: 10fr 35fr 10fr;
        }
    }

    @media (max-width: 800px) {
        .detectiveGrid {
            grid: "buttonLeft exit buttonRight" 40px "graphAndSuspects graphAndSuspects graphAndSuspects" auto "graphPanel graphPanel graphPanel" auto;
            grid-row-gap: 20px;
            grid-template-columns: 1fr 1fr 1fr;
        }

        .grid--exit {
            text-align: center;
            user-select: none;
        }

        .exitButton {
            border: 2px solid white;
            border-radius: 5px;
            padding: 8px;
            font-size: 25px;
        }

        #paperTable {
            display: none;
        }

        .grid--leaderboard {
            display: none;
        }

        .grid--graph {
            grid: "suspect1 graphMain suspect2" "suspect3 graphMain suspect4" "suspect5 graphMain suspect6";
            grid-template-columns: 5fr 14fr 5fr;
            grid-template-rows: 10fr 10fr 10fr;
        }

        .mobileButtonLeft, .mobileButtonRight {
            display: inline;
        }
    }

    @media (max-width: 530px) {
        .exitLabel1 {
            display: none;
        }

        .exitLabel2 {
            display: inline;
        }
    }

    @media (max-width: 400px) {
        .exitButton {
            border: 2px solid white;
            padding: 5px;
            font-size: 22px;
        }

        .mobileButtonLeft, .mobileButtonRight {
            display: inline;
            font-size: 22px;
            padding: 5px;
        }
    }
</style>