import Vue from 'vue'
import App from './App.vue'
import router from '@/router/router'
import { Button, Table ,TableColumn,Input,Select,Pagination,Dialog,MessageBox, Message, Tabs, TabPane} from 'element-ui'
Vue.use(Button)
Vue.use(Table)
Vue.use(TableColumn)
Vue.use(Input)
Vue.use(Select)
Vue.use(Pagination)
Vue.use(Dialog)
Vue.use(Tabs)
Vue.use(TabPane)
Vue.prototype.$confirm = MessageBox.confirm
Vue.prototype.$alert = MessageBox.alert
Vue.prototype.$message = Message
Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
