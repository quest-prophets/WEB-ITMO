<template>
    <div class="grid--graphPanel flexColumn">
        <div class="flexColumn graphPanel">

            Practice
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
        border: 2px solid white;
        padding: 20px 30px;
        border-radius: 15px;
        background: rgba(0, 0, 0, 0.6);
        box-shadow: 0 0 10px 10px rgba(0, 0, 0, 0.6);
    }

    @media (max-width: 800px) {
        .flexColumn{
            justify-content: flex-start;
        }


        .graphPanel{
            border: none;
        }
    }
</style>