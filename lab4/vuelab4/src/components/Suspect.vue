<template>
    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 400 400">
        <g stroke="white" stroke-width="2px">
            <path d="M 0 200 h 400"></path>
            <path d="M 200 0 v 400"></path>
            <path d="M 200 0 l -4 7"></path>
            <path d="M 200 0 l 4 7"></path>
            <path d="M 400 200 l -7 -4"></path>
            <path d="M 400 200 l -7 4"></path>
            <path d="M 0 0 h 50"></path>
            <path d="M 0 0 v 50"></path>
            <path d="M 400 0 h -50"></path>
            <path d="M 400 0 v 50"></path>
            <path d="M 0 400 h 50"></path>
            <path d="M 0 400 v -50"></path>
            <path d="M 400 400 h -50"></path>
            <path d="M 400 400 v -50"></path>
        </g>
        <path stroke="white" :id="ids.path1id" fill="white" d=""></path>
        <path stroke="white" :id="ids.path2id" fill="white" d=""></path>
        <path stroke="white" :id="ids.path3id" fill="white" d=""></path>
        <path stroke="white" :id="ids.path4id" fill="white" d=""></path>
    </svg>
</template>

<script>
    export default {
        name: "Suspect",
        props: ["ids"]
    }
</script>

<style scoped>

</style>