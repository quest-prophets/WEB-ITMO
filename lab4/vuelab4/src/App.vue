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

  .suspectsGrid {
    display: grid;
    grid: [row1-start] "suspect1 suspect2" [row1-end] [row2-start] "suspect3 suspect4" [row2-end] [row3-start] "suspect5 suspect6" [row3-end];
    height: 100%;
    grid-column-gap: 10px;
    grid-row-gap: 10px;
  }

  .grid--exit {
    grid-area: exit;
  }
</style>
