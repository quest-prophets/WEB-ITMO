<template>
    <div class="grid--graphPanel flexColumn">
        <div class="flexColumn graphPanel">
            <div class="flexColumn2">
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
            <div class="flexColumn2">
                <button @click="focus" class="bwButton bwButton-blackBackground">Focus</button>
                <button @click="erase" class="bwButton bwButton-blackBackground">Erase</button>
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

<style scoped>
    .flexColumn2 {
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

    .graphInputLabel2 {
        display: none;
    }

    @media (max-width: 800px) {
        .flexColumn2 {
            flex-direction: row;
        }

        .flexColumn{
            justify-content: flex-start;
        }

        .graphInput {
            width: 12vw;
            height: 2.5vh;
            margin-top: 0;
            margin-right: 30px;
        }

        .graphPanel{
            border: none;
        }

        .bwButton {
            margin-top: 20px;
            margin-right: 30px;
        }

        .graphInputLabel1 {
            display: none;
        }

        .graphInputLabel2 {
            font-size: 20px;
            display: inline;
        }

        .bwButton {
            font-size: 16px;
            width: 120px;
            height: 45px;
            user-select: none;
        }
    }
</style>