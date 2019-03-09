<template>
    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 400 400" class="suspect">
        <g class="suspectBase" stroke="white" stroke-width="2px">
            <path fill="black" d="M 0 0 h 400 v 400 h -400 Z"></path>
            <path d="M 0 200 h 400"></path>
            <path d="M 200 0 v 400"></path>
        </g>
        <g class="suspectSectors" fill="white" stroke="white">
            <path :d="topRightPath"></path>
            <path :d="topLeftPath" style="transform: rotate(-90deg); transform-origin: 200px 200px"></path>
            <path :d="bottomLeftPath" style="transform: rotate(180deg); transform-origin: 200px 200px"></path>
            <path :d="bottomRightPath" style="transform: rotate(90deg); transform-origin: 200px 200px"></path>
        </g>
    </svg>
</template>

<script>
    export default {
        name: "Suspect",
        props: ['graph'],
        methods: {
            getPath(areaNumber) {
                switch (areaNumber) {
                    case 1: //big circle
                        return "M 200 200 v -160 q 160 0 160 160 Z";
                    case 2: //small circle
                        return "M 200 200 v -80 q 80 0 80 80 Z";
                    case 3: //big square
                        return "M 200 200 v -160 h 160 v 160 Z";
                    case 4: //small square
                        return "M 200 200 v -80 h 80 v 80 Z";
                    case 6: //rectangle stand up
                        return "M 200 200 v -160 h 80 v 160 Z";
                    case 7: //rectangle lie down
                        return "M 200 200 v -80 h 160 v 80 Z";
                    case 8: //triangle equal
                        return "M 200 200 v -160 l 160 160 Z";
                    case 9: //triangle stand up
                        return "M 200 200 v -160 l 80 160 Z";
                    default:
                        return "";
                }
            }
        },
        computed: {
            topRightPath() {
                return this.getPath(this.graph.area1);
            },
            topLeftPath() {
                return this.getPath(this.graph.area2);

            },
            bottomLeftPath() {
                return this.getPath(this.graph.area3);
            },
            bottomRightPath() {
                return this.getPath(this.graph.area4);
            }
        }
    }
</script>

<style scoped>
    .suspect {
        box-shadow: white 0 0 4px 1px;
    }

    .suspect:hover {
        cursor: pointer;
        box-shadow: black 0 0 4px 1px;
    }

    .suspectBase:hover path {
        fill: white;
        stroke: black;
    }

    .suspectSectors:hover path {
        fill: white;
        stroke: black;
    }
</style>