import { createRouter, createWebHistory } from 'vue-router'
import LogIn from '../components/LogIn.vue'
import RegisterUser from '../components/RegisterUser.vue'
import SocialMedia from '../components/SocialMedia.vue'

const routes = [
  {
    path: '/',
    name: 'LogIn',
    component: LogIn
  },
  {
    path: '/RegisterUser', // 註冊頁面的路徑
    name: 'RegisterUser',
    component: RegisterUser
  },
  {
    path: '/SocialMedia',
    name: 'SocialMedia',
    component: SocialMedia
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
