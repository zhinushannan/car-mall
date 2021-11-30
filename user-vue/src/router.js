import Vue from "vue"
import VueRouter from "vue-router"

import Index from "./view/index"
import Main from "./view/main"

import CarDetail from "./view/car_detail"
import History from "./view/history"

Vue.use(VueRouter)

const routes = [
    {
        path: "/",
        name: "Index",
        component: Index,
        children: [
            {
                path: "main",
                name: "Main",
                component: Main
            },
            {
                path: "/carDetail/:id",
                name: "CarDetail",
                component: CarDetail
            },
            {
                path: "/history",
                name: "History",
                component: History
            }
        ]
    },


]

const router = new VueRouter({
    routes
})

export default router
