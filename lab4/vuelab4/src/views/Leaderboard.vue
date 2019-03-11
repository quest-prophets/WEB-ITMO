<template>
    <div class="gamePage">
        <div class="leaderboardGrid">
            <div class="grid--exit">
                <router-link to="MainMenu" class="exitButton">Main Menu</router-link>
            </div>
            <div class="grid--stats">
                <div class="stats">
                    #{{userStats.place}} — {{userStats.name}}<br>
                    Wins / Total games: {{userStats.winCount}} / {{userStats.gameCount}}<br>
                    Total shots: {{userStats.dotCount}}<br>
                    Total time: {{userStats.overallTime}} <br>
                    Score: {{userStats.score}} <br>
                    Performance ratio: {{userStats.performance}} <br>
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
                            Score
                        </td>
                        <td>
                            Performance
                        </td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="(entry,i) in leaderboardEntries" v-bind:key="i">
                        <td>
                            {{entry.place}}
                        </td>
                        <td>
                            {{entry.name}}
                        </td>
                        <td>
                            {{entry.score}}
                        </td>
                        <td>
                            {{entry.performance}}
                        </td>
                    </tr>
                    </tbody>
                </table>
                <a id="prevPage" class="pageButton" style="float: left" @click="prevPage">Prev. page</a>
                <a id="nextPage" class="pageButton" style="float: right" @click="nextPage">Next page</a>
            </div>
        </div>
    </div>
</template>

<script>
    import {getUserStats, getLeaderboardsPage, getPageCount} from "../api";

    export default {
        name: "Leaderboard",
        data() {
            return {
                leaderboardEntries: [],
                totalPages: 1,
                currentPage: 1,
                userStats: {
                    place: null,
                    name: null,
                    winCount: null,
                    gameCount: null,
                    dotCount: null,
                    overallTime: null,
                    score: null,
                    performance: null
                }
            }
        },
        async mounted() {
            this.totalPages = await getPageCount();
            document.getElementById("prevPage").classList.add("hidden");
            if (this.totalPages <= 1) {
                document.getElementById("nextPage").classList.add("hidden");
            }
            const userStats = await getUserStats();
            this.userStats = userStats;
            this.userStats.overallTime = await this.msToTime(userStats.overallTime);
            await this.loadLeaderboardPage(this.currentPage);
        },
        methods: {
            async prevPage() {
                this.currentPage--;
                document.getElementById("nextPage").classList.remove("hidden");
                if (this.currentPage === 1) {
                    document.getElementById("prevPage").classList.add("hidden");
                }
                await this.loadLeaderboardPage(this.currentPage);
            },
            async nextPage() {
                this.currentPage++;
                document.getElementById("prevPage").classList.remove("hidden");
                if (this.totalPages <= this.currentPage) {
                    document.getElementById("nextPage").classList.add("hidden");
                }
                await this.loadLeaderboardPage(this.currentPage);
            },
            async loadLeaderboardPage(page){
                this.leaderboardEntries = [];
                const response = await getLeaderboardsPage(page);
                if (response == null) return;
                response.forEach(entry => {
                    this.leaderboardEntries.push({
                        place: entry.place,
                        name: entry.name,
                        score: entry.score,
                        performance: entry.performance
                    });
                });
            },
            async msToTime(msTime) {
                const ms = msTime % 1000;
                msTime = (msTime - ms) / 1000;
                const secs = msTime % 60;
                msTime = (msTime - secs) / 60;
                const mins = msTime % 60;
                const hrs = (msTime - mins) / 60;
                return ((hrs < 10) ? ("0" + hrs) : hrs) + " : " + ((mins < 10) ? ("0" + mins) : mins) + " : " + ((secs < 10) ? ("0" + secs) : secs) + ' . ' + ms;
            }
        }
    }
</script>

<style scoped>
    .leaderboardGrid {
        display: grid;
        grid: "exit" 40px "stats" 170px "leaderboard" 70vh;
        padding: 10px 25px;
    }

    .grid--stats {
        grid-area: stats;
        margin: 0 auto;
    }

    .stats {
        font-size: 18px;
        padding: 10px;
        color: white;
    }

    .grid--exit {
        grid-area: exit;
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

    .grid--leaderboard {
        font-size: 18px;
        grid-area: leaderboard;
        border-radius: 10px;
        background: rgba(255, 255, 255, 0.96);
        width: 70%;
        margin: 0 auto;
        height: 410px;
    }

    .leaderboardTable {
        width: 100%;
    }

    table {
        text-align: center;
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

    .pageButton{
        padding: 15px;
        cursor: pointer;
    }

    .pageButton:hover{
        text-decoration: underline;
    }

    @media (max-width: 800px) {
        .grid--leaderboard {
            width: 85%;
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

        .leaderboardGrid {
            grid: "exit" 50px "stats" 170px "leaderboard" 70vh;
        }
    }

    @media (max-width: 600px) {
        .grid--leaderboard {
            width: 100%;
        }

    }
</style>