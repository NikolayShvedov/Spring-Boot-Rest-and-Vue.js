import Vue from 'vue'
import VueRouter from 'vue-router'
import MessagesList from '../static/js/pages/MessagesList.vue'
import Auth from '../static/js/pages/Auth.vue'
import Profile from '../static/js/pages/Profile.vue'

Vue.use(VueRouter)

const routes = [
    { path: '/', component: MessagesList },
    { path: '/auth', component: Auth },
    { path: '/profile', component: Profile },
    { path: '*', component: MessagesList },
]

export default new VueRouter({
    mode: 'history',
    routes
})
