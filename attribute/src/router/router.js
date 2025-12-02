import Vue from 'vue'
import Router from 'vue-router'
Vue.use(Router)
export default new Router({
    routes: [
        {
            path: '/',
            component: () => import('@/pages/tables.vue'),
            children: [
                {
                    path: '/',
                    name: 'index',
                    redirect: '',
                    component: () => import('@/pages/tables.vue'),
                },
            ],

        },
        {
          path: '/specification',
          name: 'specification',
          component: () => import('@/pages/specification.vue'),
        }
        
    ]
})
