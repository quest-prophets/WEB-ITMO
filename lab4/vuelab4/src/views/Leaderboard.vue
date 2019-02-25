<template>
    <div class="gamePage">
        <div class="leaderboardGrid">
            <div class="grid--exit">
                <router-link to="MainMenu" class="exitButton">Main Menu</router-link>
            </div>
            <div class="grid--stats">
                <div class="stats">
                    #Place Name <br>
                    Wins / Total games: <br>
                    Total shots: <br>
                    Total time:
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
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Leaderboard"
    }
</script>

<style scoped>
    .leaderboardGrid {
        display: grid;
        grid: "exit" 40px "stats" 140px "leaderboard" 70vh;
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
        grid-area: leaderboard;
        border-radius: 10px;
        background: rgba(255, 255, 255, 0.96);
        width: 70%;
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
            grid: "exit" 50px "stats" 130px "leaderboard" 70vh;
        }
    }

    @media (max-width: 600px) {
        .grid--leaderboard {
            width: 100%;
        }

    }
</style>