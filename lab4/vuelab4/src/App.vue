<template>
  <div id="app" class="fullscreen">
    <router-view class="fullscreen"/>
  </div>
</template>

<style>
  body {
    background: black;
    font-family: "Courier new", monospace;
    margin: 0;
  }

  .fullscreen {
    min-height: 100vh;
    min-width: 100vw;
  }

  .flexColumn {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }

  .gamePage {
    font-family: 'Exo', monospace;
    background: url('assets/gamePage.svg') no-repeat fixed center center;
    background-size: cover;
  }

  .bwButton {
    font-family: "Arial", monospace;
    text-align: center;
    text-decoration: none;
    width: 100px;
    padding: 7px 12px;
    color: white;
    background-color: black;
    font-weight: bold;
    margin-top: 10px;
    cursor: pointer;
    outline: none;
  }

  .bwButton-blackBackground {
    border: 2px solid white;
  }

  .bwButton-blackBackground:hover {
    background: white;
    color: black;
  }

  .bwButton-whiteBackground {
    border: 2px solid black;
  }

  .bwButton-whiteBackground:hover {
    background: white;
    color: black;
  }


  .hidden {
    display: none;
  }
</style>
