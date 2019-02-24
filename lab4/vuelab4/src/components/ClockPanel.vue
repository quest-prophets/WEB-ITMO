<template>
    <div class="grid--graphPanel flexColumn">
        <div class="flexColumn graphPanel">
            <button @click="start" id="startButton" class="bwButton bwButton-blackBackground startButton">Start!</button>
            <div class="hidden clock">
                00:00:00
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "NoRPanel",
        data: function () {
            return {r: null, x: null, y: null}
        },
        methods: {
            start: function () {
                let hiddens = document.querySelectorAll(".hidden");
                for (var i = 0; i < hiddens.length; i++) {
                    hiddens[i].classList.remove("hidden");
                }
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

    .flexColumn {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
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

    .clock{
        font-size: 24px;
        margin-top: 15px;
        margin-bottom: 15px;
    }

    .hidden {
        display: none;
    }
</style>