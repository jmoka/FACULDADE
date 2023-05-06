import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/ordenando',
    name: 'ordenando',
    component: () => import(/* webpackChunkName: "about" */ '../views/OrdenacaoView.vue')
  }, 
  {
    path: '/api',
    name: 'api',
    component: () => import(/* webpackChunkName: "about" */ '../views/ConsumoAPI_View.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
