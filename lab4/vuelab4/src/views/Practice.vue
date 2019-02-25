<template>
    <div class="gamePage">
        <div class="practiceGrid">
            <div class="grid--exit">
                <router-link to="MainMenu" class="exitButton">
                    Main Menu
                </router-link>
            </div>

            <div class="grid--graph">
                <div class="flexColumn grid--graphMain">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 400 400" class="graphMain">
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
                        <g id="graphDots"></g>
                    </svg>
                </div>
                <div class="flexColumn">
                    <Suspect style="grid-area: suspect1"
                             :ids="{path1id: 'suspect1--path1', path2id: 'suspect1--path2',path3id: 'suspect1--path3',path4id: 'suspect1--path4'}"/>
                </div>
                <div class="flexColumn">
                    <Suspect style="grid-area: suspect2"
                             :ids="{path1id: 'suspect2--path1', path2id: 'suspect2--path2',path3id: 'suspect2--path3',path4id: 'suspect2--path4'}"/>
                </div>
                <div class="flexColumn">
                    <Suspect style="grid-area: suspect3"
                             :ids="{path1id: 'suspect3--path1', path2id: 'suspect3--path2',path3id: 'suspect3--path3',path4id: 'suspect3--path4'}"/>
                </div>
                <div class="flexColumn">
                    <Suspect style="grid-area: suspect4"
                             :ids="{path1id: 'suspect4--path1', path2id: 'suspect4--path2',path3id: 'suspect4--path3',path4id: 'suspect4--path4'}"/>
                </div>
                <div class="flexColumn">
                    <Suspect style="grid-area: suspect5"
                             :ids="{path1id: 'suspect5--path1', path2id: 'suspect5--path2',path3id: 'suspect5--path3',path4id: 'suspect5--path4'}"/>
                </div>
                <div class="flexColumn">
                    <Suspect style="grid-area: suspect6"
                             :ids="{path1id: 'suspect6--path1', path2id: 'suspect6--path2',path3id: 'suspect6--path3',path4id: 'suspect6--path4'}"/>
                </div>
            </div>
            <HelpPanel id="graphPanel"/>
        </div>
    </div>
</template>

<script>
    import HelpPanel from "../components/HelpPanel";
    import Suspect from "../components/Suspect";

    export default {
        name: "Practice",
        components: {Suspect, HelpPanel}
    }
</script>

<style scoped>
    .grid--exit {
        grid-area: exit;
    }

    .exitButton {
        text-decoration: none;
        color: white;
        font-size: 20px;
    }

    .practiceGrid {
        display: grid;
        padding: 10px 20px 30vh;
        height: 100vh;
        grid-column-gap: 20px;
        grid: "exit exit exit exit" 50px "nothingL graphAndSuspects graphPanel nothingR" auto;
        grid-template-columns: 3fr 10fr 5fr 3fr;
        box-sizing: border-box;
    }

    .exitButton:hover {
        cursor: pointer;
        text-decoration: underline;
    }

    .grid--graph {
        display: grid;
        grid-area: graphAndSuspects;
        user-select: none;
        grid: "suspect1 graphMain suspect2" "suspect3 graphMain suspect4" "suspect5 graphMain suspect6";
        grid-column-gap: 20px;
        grid-template-columns: 10fr 35fr 10fr;
    }

    .grid--graphMain {
        grid-area: graphMain;
    }

    .graphMain:hover {
        cursor: url("../assets/aim.svg") 16 16, pointer;
    }

    @media (max-width: 1400px) {
        .practiceGrid {
            grid-template-columns: 1fr 10fr 5fr 1fr;
        }
    }

    @media (max-width: 1000px) {
        .practiceGrid {
            grid-template-columns: 0 10fr 5fr 0;
        }
    }

    @media (max-width: 800px) {
        .practiceGrid {
            grid: "exit" 40px "graphAndSuspects" auto "graphPanel" auto;
            grid-row-gap: 30px;
            grid-template-columns: 1fr;
        }

        .exitButton {
            font-size: 25px;
            border: 2px solid white;
            padding: 3px 15px;
        }

        .exitButton:hover{
            text-decoration: none;
            color: black;
            background: white;
        }

        .grid--graph {
            grid: "suspect1 graphMain suspect2" "suspect3 graphMain suspect4" "suspect5 graphMain suspect6";
            grid-row-gap: 20px;
            grid-template-columns: 5fr 14fr 5fr;
            grid-template-rows: 1fr 1fr 1fr;
        }
    }

    @media (max-width: 500px) {
        .grid--graph{
            width: 90%;
            margin: 0 auto;
        }

        .practiceGrid {
            grid-row-gap: 10px;
            padding: 10px 10px;
        }

        .grid--graph {
            grid: "suspect1 suspect2 suspect3" "graphMain graphMain graphMain" "suspect4 suspect5 suspect6";
        }
    }
</style>