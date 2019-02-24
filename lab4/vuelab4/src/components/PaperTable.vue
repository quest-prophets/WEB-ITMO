<template>
    <div class="paper">
        <table>
            <thead>
            <tr>
                <td>
                    R
                </td>
                <td>
                    X
                </td>
                <td>
                    Y
                </td>
                <td>
                    FIGURA
                </td>
                <td>
                    TIME
                </td>
            </tr>
            </thead>
            <tbody>
            <tr v-for="result in results">
                <td>
                    {{result.r}}
                </td>
                <td>
                    {{result.x}}
                </td>
                <td>
                    {{result.y}}
                </td>
                <td>
                    <span v-if="result.figura">Present</span>
                    <span v-else>Absent</span>
                </td>
                <td>
                    {{result.time}}
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    export default {
        name: "PaperTable",
        props: ["results"]
    }
</script>

<style scoped>
    .paper {
        text-align: center;
        box-sizing: border-box;
        grid-area: graphTable;
        background: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
        margin: 26px auto 0;
        max-width: 300px;
        min-height: 300px;
        padding: 24px;
        position: relative;
        width: 80%;
        z-index: 1;
    }

    .paper:before, .paper:after {
        content: "";
        height: 98%;
        position: absolute;
        width: 100%;
        z-index: -1;
    }

    .paper:before {
        background: #fafafa;
        box-shadow: 0 0 8px rgba(0, 0, 0, 0.2);
        left: -5px;
        top: 4px;
        transform: rotate(-2.5deg);
    }

    .paper:after {
        background: #f6f6f6;
        box-shadow: 0 0 3px rgba(0, 0, 0, 0.2);
        right: -4px;
        top: -1px;
        transform: rotate(1.7deg);
    }

    table {
        width: 95%;
        margin: 0 auto;
        font-family: 'Handlee', cursive;
        border-collapse: collapse;
    }

    thead {
        border-bottom: 2px solid black;
    }

    td {
        padding: 4px 7px;
        border-right: 2px solid black;
    }

    td:last-child {
        border: none;
    }
</style>