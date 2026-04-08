import BodyUltimosAdd from '@/components/BodyUltimosAdd.vue'
import CadastroLivro from '@/components/CadastroLivro.vue'
import Colecao from '@/components/Colecao.vue'
import EditarLivro from '@/components/EditarLivro.vue'
import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: BodyUltimosAdd
    },
    {
      path: '/colecao',
      name: 'colecao',
      component: Colecao
    },
    {
      path: '/cadastro',
      name: 'cadastro',
      component: CadastroLivro
    },
    {
      path: '/editar',
      name: 'editar',
      component: EditarLivro
    }

  ],
})

export default router
