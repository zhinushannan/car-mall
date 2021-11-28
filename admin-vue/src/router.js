import Vue from "vue"
import VueRouter from "vue-router"

import Index from "./view/index"

import UserList from "./view/user/list"

import CarList from "./view/car/list"

Vue.use(VueRouter)

const routes = [
    {
        path: "/",
        name: "Index",
        component: Index
    },
    {
        path: "/user/list",
        name: "UserList",
        component: UserList
    },
    {
        path: "/car/list",
        name: "CarList",
        component: CarList
    }
]

const router = new VueRouter({
    routes
})

export default router
