<template>
    <div class="grid--graphPanel flexColumn">
        <div class="flexColumn graphPanel">
            <button @click="start" id="startButton" class="bwButton-blackBackground startButton">Start!</button>
            <div class="hidden">X: &emsp;<input v-model="x" type="number" step="0.1" min="-5" max="3"
                                                placeholder="-5..3"
                                                class="graphInput hidden"></div>
            <div class="hidden">Y: &emsp;<input v-model="y" type="number" step="0.1" min="-3" max="3"
                                                placeholder="-3..3"
                                                class="graphInput hidden"></div>
            <button @click="focus" class="bwButton hidden">Focus</button>
            <button @click="erase" class="bwButton hidden">Erase</button>
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
            focus: function () {
                this.$emit("add-data", {r: this.r, x: this.x, y: this.y})
            },
            erase: function () {
                this.$emit("erase-data")
            },
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
    .bwButton {
        width: 100px;
        padding: 7px 12px;
        color: white;
        background-color: black;
        font-weight: bold;
        margin-top: 10px;
        cursor: pointer;
        outline: none;
        border: 2px solid white;
    }

    .bwButton:hover {
        background: white;
        color: black;
    }

    .startButton{
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

    .graphInput {
        color: white;
        background-color: black;
        padding: 8px 12px;
        font-weight: bold;
        margin-top: 10px;
        border-radius: 6px;
        border: 2px solid white;
        width: 7vw;
    }

    .hidden {
        display: none;
    }
</style>