<template>
    <div class="grid--graphPanel flexColumnGraphPanel">
        <div class="flexColumnGraphPanel graphPanelPractice">
            <div class="flexColumnGraphPanel2">
                <div>
                    <span class="graphInputLabel1">R: &emsp;</span>
                    <span class="graphInputLabel2">R: </span>
                    <input v-model="r" type="number" step="0.1" min="1" max="5" placeholder="1..5"
                           class="graphInput"></div>
                <div>
                    <span class="graphInputLabel1">X: &emsp;</span>
                    <span class="graphInputLabel2">X: </span>
                    <input v-model="x" type="number" step="0.1" min="-5" max="3" placeholder="-5..3"
                           class="graphInput">
                </div>
                <div>
                    <span class="graphInputLabel1">Y: &emsp;</span>
                    <span class="graphInputLabel2">Y: </span>
                    <input v-model="y" type="number" step="0.1" min="-3" max="3" placeholder="-3..3"
                           class="graphInput">
                </div>
            </div>
            <div class="flexColumnGraphPanel2">
                <button @click="focus" class="bwButtonGP bwButton-blackBackground">Focus</button>
                <button @click="erase" class="bwButtonGP bwButton-blackBackground">Erase</button>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "GraphPanel",
        data: function () {
            return {r: null, x: null, y: null}
        },
        methods: {
            focus: function () {
                this.$emit("add-data", {r: this.r, x: this.x, y: this.y})
            },
            erase: function () {
                this.$emit("erase-data")
            }
        }
    }
</script>

<style>
    .bwButtonGP {
        width: 100px;
        padding: 7px 12px;
        color: white;
        background-color: black;
        font-weight: bold;
        margin-top: 10px;
        cursor: pointer;
        outline: none;
    }

    .bwButton-blackBackground {
        border: 2px solid white;
    }

    .bwButton-blackBackground:hover {
        background: white;
        color: black;
    }

    .flexColumnGraphPanel {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .flexColumnGraphPanel2 {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .grid--graphPanel {
        grid-area: graphPanel;
    }

    .graphPanelPractice {
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

    .graphInputLabel2 {
        display: none;
    }

    @media (max-width: 1200px) {
        .graphInput {
            width: 9vw;
        }

        .bwButtonGP{
            width: 115px;
            height: 40px;
        }
    }

    @media (max-width: 1055px) {
        .graphInput {
            width: 10vw;
        }

        .grid--graphPanel {
            align-items: flex-start;
        }
    }

    @media (max-width: 850px) {
        .graphInput {
            width: 11vw;
        }

        .grid--graphPanel {
            align-items: center;
        }

        .bwButtonGP{
            width: 120px;
            height: 45px;
        }

        .graphPanelPractice {
            padding: 15px 25px;
        }
    }

    @media (max-width: 700px) {
        .flexColumnGraphPanel2 {
            flex-direction: row;
        }

        .graphInput {
            width: 12vw;
            margin-top: 0;
            margin-right: 30px;
        }

        .graphPanelPractice{
            border: none;
        }

        .bwButtonGP {
            margin-top: 20px;
            margin-right: 30px;
        }

        .graphInputLabel1 {
            display: none;
        }

        .graphInputLabel2 {
            display: inline;
        }
    }
</style>