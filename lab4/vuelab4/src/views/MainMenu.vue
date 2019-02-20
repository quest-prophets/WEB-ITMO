<template>
    <div class="menuPage">
        <div class="mainMenuButtonDiv">
            <router-link to="Practice" class="mainMenuButton">
                P<a>R</a>A<a>C</a>T<a>I</a>C<a>E</a>
            </router-link>
        </div>
        <div class="mainMenuButtonDiv">
            <router-link to="Detective" class="mainMenuButton">
                D<a>E</a>T<a>E</a>C<a>T</a>I<a>V</a>E
            </router-link>
        </div>
        <div class="mainMenuButtonDiv">
            <router-link to="Practice" class="mainMenuButton">
                T<a>I</a>M<a>E</a>&nbsp;<a>A</a>T<a>T</a>A<a>C</a>K
            </router-link>
        </div>
        <div class="mainMenuButtonDiv">
            <router-link to="/" class="mainMenuButton">
                R<a>E</a>S<a>I</a>G<a>N</a>
            </router-link>
        </div>
        <br>
    </div>
</template>

<script>
    export default {
        name: "MainMenu"
    }
</script>

<style>
    .menuPage {
        overflow: hidden;
        background: url('../assets/menuPage.svg') no-repeat fixed center center;
        background-size: cover;
    }

    .mainMenuButton {
        text-decoration: none;
        user-select: none;
        -webkit-text-stroke: 1px black;
        font-weight: bold;
        color: white;
        font-size: 80px;
        margin-left: 10%;
        transition: margin-left 0.13s linear;
    }

    .mainMenuButton:hover {
        background: black;
        border: 5px solid white;
        cursor: pointer;
        margin-left: calc(10% - 15px);
    }

    .mainMenuButton:hover a {
        color: black;
        background: white;
    }

    .mainMenuButtonDiv{
        margin-top: 15px;
    }

    .mainMenuButtonDiv:first-child {
        margin-top: 3%;
    }
</style>