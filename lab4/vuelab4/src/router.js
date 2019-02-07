import Vue from 'vue'
import Router from 'vue-router'
import Index from './views/Index.vue'
import MainMenu from './views/MainMenu.vue'
import Practice from './views/Practice.vue'


Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            name: 'Who are you?',
            component: Index
        },
        {
            path: '/mainmenu',
            name: 'Main menu',
            component: MainMenu
        },
        {
            path: '/practice',
            name: 'Practice',
            component: Practice
        }
    ]
})
