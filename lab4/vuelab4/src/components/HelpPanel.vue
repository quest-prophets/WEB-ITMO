<template>
    <div class="grid--graphPanel flexColumn">
        <div class="flexColumn graphPanel">
            You are a detective and your goal is to guess the Figura of the culprit. <br> <br>
            Click on the empty graph to feel the presence of culprit's Figura. You will see X on spots where Figura is
            absent and O where it's present. <br> <br>
            There are 6 suspects. You win if you choose the correct one and fail otherwise. <br> <br>
            Practice here before entering Competitive mode where every shot and every second counts!
        </div>
    </div>
</template>

<script>
    export default {
        name: "GraphPanel"
    }
</script>

<style scoped>
    .grid--graphPanel {
        grid-area: graphPanel;
    }

    .graphPanel {
        color: white;
        font-size: 18px;
        border: 2px solid white;
        padding: 20px 30px;
        border-radius: 15px;
        background: rgba(0, 0, 0, 0.6);
        box-shadow: 0 0 10px 10px rgba(0, 0, 0, 0.6);
    }

    @media (max-width: 800px) {
        .flexColumn {
            justify-content: flex-start;
        }
    }
</style>