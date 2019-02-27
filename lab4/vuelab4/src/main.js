import Vue from 'vue'
import App from './App.vue'
import router from './router'

Vue.config.productionTip = false;

var vue;
export default vue = new Vue({
    router,
    data: function () {
        return {username: null};
    },
    methods: {
        update(name) {
            this.username = name;
        }
    },
    render: h => h(App)
}).$mount('#app');