<template>
    <div class="loginPage">
        <div class="flexColumn" style="height: 100vh">
            <div class="logo">F I G U R A</div>
            <div class="flexColumn loginShadow"
                 style="background: white; padding: 10px 20px; box-shadow: 0 0 22px 30px white">
                <input type="text" class="loginInput" placeholder="Login">
                <input type="password" class="loginInput" placeholder="Password">
                <router-link to="MainMenu" class="bwButton bwButton-whiteBackground">Log in</router-link>
                <router-link to="MainMenu" class="bwButton bwButton-whiteBackground">Register</router-link>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "index"
    }
</script>

<style>
    .loginPage {
        overflow: hidden;
        background: url('../assets/loginPage.svg') no-repeat fixed center center;
        background-size: cover;
    }

    .flexColumn {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .loginShadow {
        animation: logShadow 0.55s forwards;
    }

    @keyframes logShadow {
        from {
            box-shadow: 0 0 22px 10px white;
        }
        to {
            box-shadow: 0 0 22px 30px white;
        }
    }

    .loginInput {
        color: white;
        background-color: black;
        padding: 8px 12px;
        font-weight: bold;
        margin-top: 10px;
        border-radius: 6px;
        border: none;
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

    .bwButton-whiteBackground {
        border: 2px solid black;
    }

    .bwButton-whiteBackground:hover {
        background: white;
        color: black;
    }

    .logo {
        text-shadow: 3px 3px 10px white;
        font-size: 120px;
        font-weight: bold;
        margin-top: -25vh;
        margin-bottom: 10vh;
        font-family: "Courier new", monospace;
        -webkit-text-stroke: 2px white;
        opacity: 0;
        animation: logoAppearance 1.5s 2s forwards;
    }

    @keyframes logoAppearance {
        from {
            opacity: 0;
        }
        to {
            opacity: 1;
        }
    }

    @media (max-width: 1000px) {
        .logo{
            font-size: 13vw;
        }
    }
</style>