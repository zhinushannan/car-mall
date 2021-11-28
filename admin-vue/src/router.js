import Vue from "vue"
import VueRouter from "vue-router"

import Index from "./view/index"

import UserList from "./view/user/list"

Vue.use(VueRouter)

const routes = [
    {
        path: "/",
        name: "Index",
        component: Index
    },
    {
        path: "/user/list",
        name: "User",
        component: UserList
    }
]

const router = new VueRouter({
    routes
})

export default router
