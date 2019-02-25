<template>
    <div class="grid--graphPanel flexColumn">
        <div class="flexColumn graphPanel">
            <button @click="start" id="startButton" class="bwButton bwButton-blackBackground startButton">Start!
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
    .startButton {
        margin-top: 0;
    }

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

    .clock {
        font-size: 28px;
        margin-top: 15px;
        margin-bottom: 15px;
    }

    @media (max-width: 800px) {
        .graphPanel {
            border: none;
        }

        .clock {
            font-size: 30px;
        }

        .bwButton {
            font-size: 16px;
            width: 120px;
            height: 45px;
            user-select: none;
        }

        .flexColumn {
            justify-content: flex-start;
        }
    }
</style>