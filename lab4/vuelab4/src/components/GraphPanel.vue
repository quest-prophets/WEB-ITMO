<template>
    <div class="grid--graphPanel flexColumn">
        <div class="flexColumn graphPanel">
            <div class="flexColumn2">
                <div>
                    <span class="graphInputLabel1">R: &emsp;</span>
                    <span class="graphInputLabel2">R: </span>
                    <input v-model="r" type="number" step="0.1" min="1" max="5" placeholder="1..5"
                           class="graphInput" @input="setR">
                </div>
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
            setR() {
                this.$emit("change-r", {r: this.r})
            },
            focus() {
                this.$emit("add-data", {x: this.x, y: this.y})
            },
            erase() {
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

    @media (max-width: 1200px) {
        .graphInput {
            width: 9vw;
        }

        .bwButton {
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

        .bwButton {
            width: 120px;
            height: 45px;
        }

        .graphPanel {
            padding: 15px 25px;
        }
    }

    @media (max-width: 700px) {
        .flexColumn2 {
            flex-direction: row;
        }

        .graphInput {
            width: 12.5vw;
            margin-top: 0;
            margin-right: 30px;
        }

        .graphPanel {
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
            display: inline;
        }
    }
</style>