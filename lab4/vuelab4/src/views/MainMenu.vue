<template>
    <div class="menuPage">
        <div class="mainMenuButtonDiv">
<span class="mainMenuButton">
    S<w>T</w>O<w>R</w>Y<w> </w>M<w>O</w>D<w>E</w>
</span>
        </div>
        <div class="mainMenuButtonDiv">
<span class="mainMenuButton" onclick="location.href = 'practice.html';">
    P<w>R</w>A<w>C</w>T<w>I</w>C<w>E</w>
</span>
        </div>
        <div class="mainMenuButtonDiv">
    <span class="mainMenuButton">
    S<w>O</w>L<w>V</w>E<w> </w>A<w> </w>C<w>A</w>S<w>E</w>
</span>
        </div>
        <div class="mainMenuButtonDiv">
<span class="mainMenuButton">
    T<w>I</w>M<w>E</w> <w>A</w>T<w>T</w>A<w>C</w>K
</span>
        </div>
        <div class="mainMenuButtonDiv">
<span class="mainMenuButton" onclick="location.href = 'index.html';">
    L<w>O</w>G<w> </w>O<w>U</w>T
</span>
        </div>
    </div>
</template>

<script>
    export default {
        name: "MainMenu"
    }
</script>

<style>
    body {
        background: black;
        font-family: "Courier new", monospace;
    }

    .menuPage {
        overflow: hidden;
        background: url('../assets/menuPage.svg') no-repeat fixed center center;
        background-size: cover;
    }

    .mainMenuButton {
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
        margin-left: 7%;
    }

    .mainMenuButton:hover w {
        color: black;
        background: white;
    }

    .mainMenuButtonDiv {
        margin-top: 15px;
    }

    .mainMenuButtonDiv:first-child {
        margin-top: 3%;
    }
</style>