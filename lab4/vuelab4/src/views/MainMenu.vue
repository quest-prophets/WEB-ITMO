<template>
    <div class="menuPage">
        <router-link to="labmode" class="mainMenuButtonDiv">
            <span class="mainMenuButton">
                <a>L</a>A<a>B</a>&nbsp;<a>M</a>O<a>D</a>E
            </span>
        </router-link>
        <router-link to="practice" class="mainMenuButtonDiv">
            <span class="mainMenuButton">
                P<a>R</a>A<a>C</a>T<a>I</a>C<a>E</a>
            </span>
        </router-link>
        <router-link to="competitive" class="mainMenuButtonDiv">
            <span class="mainMenuButton">
                <a>C</a>O<a>M</a>P<a>E</a>T<a>I</a>T<a>I</a>V<a>E</a>
            </span>
        </router-link>
        <router-link to="leaderboard" class="mainMenuButtonDiv">
            <span class="mainMenuButton">
                L<a>E</a>A<a>D</a>E<a>R</a>B<a>O</a>A<a>R</a>D
            </span>
        </router-link>
        <router-link to="/" class="mainMenuButtonDiv">
            <span class="mainMenuButton">
                <a>L</a>O<a>G</a>&nbsp;<a>O</a>U<a>T</a>
            </span>
        </router-link>
    </div>
</template>

<script>
    export default {
        name: "MainMenu"
    }
</script>

<style scoped>
    .menuPage {
        overflow: hidden;
        text-align: center;
        background: url('../assets/menuPage.svg') no-repeat fixed center center;
        background-size: cover;
    }

    .mainMenuButton {
        font-family: "Courier new", monospace;
        user-select: none;
        -webkit-text-stroke: 1px black;
        font-weight: bold;
        color: white;
        font-size: 90px;
    }

    .mainMenuButtonDiv:hover .mainMenuButton {
        border: 5px solid white;
        color: white;
        background: black;
        transform: scale(1.2);
    }

    .mainMenuButtonDiv:hover a {
        color: black;
        background: white;
    }

    .mainMenuButtonDiv:hover {
        cursor: pointer;
        margin-left: -3%;
    }

    .mainMenuButtonDiv {
        display: block;
        text-decoration: none;
        margin-top: 10px;
        transition: margin-left 0.2s;
    }

    .mainMenuButtonDiv:nth-child(odd) {
        animation: slideFromLeft 0.4s forwards;
    }

    .mainMenuButtonDiv:nth-child(even) {
        animation: slideFromRight 0.4s forwards;
    }

    @keyframes slideFromLeft {
        from {
            transform: translateX(-100%);
        }
        to {
            transform: translateX(0);
        }
    }

    @keyframes slideFromRight {
        from {
            transform: translateX(100%);
        }
        to {
            transform: translateX(0);
        }
    }

    .mainMenuButtonDiv:first-child {
        margin-top: 50px;
    }

    @media (max-width: 1055px) {
        .mainMenuButtonDiv:first-child {
            margin-top: 12vh;
        }

        .menuPage{
            background: url('../assets/menuPageStatic.svg') no-repeat fixed center center;
            background-size: cover;
        }
    }

    @media (max-width: 650px) {
        .mainMenuButtonDiv:first-child {
            margin-top: 16vh;
        }

        .mainMenuButton{
            font-size: 14vw;
        }
    }
</style>