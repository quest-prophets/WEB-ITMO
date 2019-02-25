import Vue from 'vue'
import Router from 'vue-router'
import Index from './views/Index.vue'
import MainMenu from './views/MainMenu.vue'
import LabMode from './views/LabMode.vue'
import Practice from './views/Practice.vue'
import competitive from './views/Competitive.vue'
import Leaderboard from "./views/Leaderboard";


Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            name: 'Login',
            component: Index
        },
        {
            path: '/mainmenu',
            name: 'MainMenu',
            component: MainMenu
        },
        {
            path: '/labmode',
            name: 'LabMode',
            component: LabMode
        },
        {
            path: '/practice',
            name: 'Practice',
            component: Practice
        },
        {
            path: '/competitive',
            name: 'Competitive',
            component: competitive
        }
        ,
        {
            path: '/leaderboard',
            name: 'Leaderboard',
            component: Leaderboard
        }
    ]
})
