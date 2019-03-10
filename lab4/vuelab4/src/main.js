import Vue from 'vue'
import App from './App.vue'
import {router, bindVue} from './router'
import {getAuth} from "./api";

Vue.config.productionTip = false;

getAuth().then(name => {
    const vue = new Vue({
        router,
        data: function () {
            return {username: name};
        },
        methods: {
            update(name) {
                this.username = name;
            }
        },
        render: h => h(App)
    }).$mount('#app');
    bindVue(vue);
});