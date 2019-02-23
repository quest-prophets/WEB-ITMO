<template>
    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 400 400">
        <g class="suspectBase" stroke="white" stroke-width="2px">
            <path fill="black" d="M 0 0 h 400 v 400 h -400 Z"></path>
            <path d="M 0 200 h 400"></path>
            <path d="M 200 0 v 400"></path>
        </g>
        <g class="suspectSectors" fill="white" stroke="white">
            <path :id="ids.path1id" d=""></path>
            <path :id="ids.path2id" d=""></path>
            <path :id="ids.path3id" d=""></path>
            <path :id="ids.path4id" d=""></path>
        </g>
    </svg>
</template>

<script>
    export default {
        name: "Suspect",
        props: ["ids"]
    }
</script>

<style scoped>
    .suspectBase:hover path{
        fill: white;
        stroke: black;
    }
    .suspectSectors:hover path{
        fill: white;
        stroke: black;
    }
</style>