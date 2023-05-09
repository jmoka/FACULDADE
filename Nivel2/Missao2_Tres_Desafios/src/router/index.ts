import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import CapaView from '../views/CapaView.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'capa',
    component: CapaView
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
  },
  {
    path: '/receitas',
    name: 'receitas',
    component: () => import(/* webpackChunkName: "about" */ '../views/ReceitasView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
