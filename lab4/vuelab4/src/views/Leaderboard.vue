<template>
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
</template>

<script>
    export default {
        name: "Leaderboard"
    }
</script>

<style scoped>
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
</style>