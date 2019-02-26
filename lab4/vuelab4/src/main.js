import Vue from 'vue'
import App from './App.vue'
import router from './router'
import {getAuth} from './api'

Vue.config.productionTip = false;

getAuth().then(function (name) {
    new Vue({
        router,
        data: function () {
            return {username: name};
        },
        render: h => h(App)
    }).$mount('#app');
});