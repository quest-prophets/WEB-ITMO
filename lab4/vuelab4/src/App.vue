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
</style>
