import Vue from 'vue'
import Router from 'vue-router'
import Index from './views/Index.vue'
import MainMenu from './views/MainMenu.vue'
import Practice from './views/Practice.vue'
import Detective from './views/Detective.vue'


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
            path: '/practice',
            name: 'Practice',
            component: Practice
        },
        {
            path: '/detective',
            name: 'Detective',
            component: Detective
        }
    ]
})
