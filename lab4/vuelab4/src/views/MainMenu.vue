<template>
    <div class="menuPage">
        <router-link to="practice" class="mainMenuButtonDiv">
            <span class="mainMenuButton">
                P<a>R</a>A<a>C</a>T<a>I</a>C<a>E</a>
            </span>
        </router-link>
        <router-link to="detective" class="mainMenuButtonDiv">
            <span class="mainMenuButton">
                D<a>E</a>T<a>E</a>C<a>T</a>I<a>V</a>E
            </span>
        </router-link>
        <router-link to="timeattack" class="mainMenuButtonDiv">
            <span class="mainMenuButton">
                <span id="normalTimeAttack">
                    T<a>I</a>M<a>E</a>&nbsp;<a>A</a>T<a>T</a>A<a>C</a>K
                </span>
                <span id="hiddenTimeAttack">
                    T<a>I</a>M<a>E</a>&nbsp;<a>A</a>T<a>K</a>
                </span>
            </span>
        </router-link>
        <router-link to="/" class="mainMenuButtonDiv">
            <span class="mainMenuButton">
                R<a>E</a>S<a>I</a>G<a>N</a>
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

    #hiddenTimeAttack {
        display: none;
    }

    @media (max-width: 1055px) {
        .mainMenuButtonDiv:first-child {
            margin-top: 15vh;
        }

        .menuPage{
            background: url('../assets/menuPageStatic.svg') no-repeat fixed center center;
            background-size: cover;
        }
    }

    @media (max-width: 650px) {
        #hiddenTimeAttack {
            display: inline;
        }

        #normalTimeAttack {
            display: none;
        }

        .mainMenuButtonDiv:first-child {
            margin-top: 20vh;
        }
    }

    @media (max-width: 550px) {
        .mainMenuButton {
            font-size: 17vw;
        }
    }
</style>