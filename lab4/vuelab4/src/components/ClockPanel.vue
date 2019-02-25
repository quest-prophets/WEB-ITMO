<template>
    <div class="grid--graphPanel flexColumn">
        <div class="flexColumn graphPanel">
            <button @click="start" id="startButton" class="bwButton bwButton-blackBackground">Start!
            </button>
            <div id="clock" class="hidden clock">
                00:00:00
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "ClockPanel",
        methods: {
            start: function () {
                document.getElementById("clock").classList.remove("hidden");
                document.getElementById("startButton").classList.add("hidden");
                this.$emit("start-game")
            }
        }
    }
</script>

<style scoped>
    .grid--graphPanel {
        grid-area: graphPanel;
    }

    .flexColumn {
        justify-content: flex-start;
    }

    .graphPanel {
        color: white;
        padding: 20px 30px;
        background: rgba(0, 0, 0, 0.6);
        box-shadow: 0 0 10px 10px rgba(0, 0, 0, 0.6);
    }

    .bwButton {
        margin-top: 0;
        font-size: 18px;
        width: 130px;
        height: 50px;
    }

    .clock {
        font-size: 32px;
        margin-top: 15px;
        margin-bottom: 15px;
    }

    @media (max-width: 800px) {
        .graphPanel {
            border: none;
        }
    }
</style>