import { createRouter, createWebHashHistory } from 'vue-router'
import index from '../views'
import home from '../views/pages/home.vue'
import login from '../views/pages/login.vue'
import yonghuList from '@/views/pages/yonghu/list'
import yonghuDetail from '@/views/pages/yonghu/formModel'
import yonghuAdd from '@/views/pages/yonghu/formAdd'
import yonghuRegister from '@/views/pages/yonghu/register'
import yonghuCenter from '@/views/pages/yonghu/center'
import shangpinfenleiList from '@/views/pages/shangpinfenlei/list'
import shangpinfenleiDetail from '@/views/pages/shangpinfenlei/formModel'
import shangpinfenleiAdd from '@/views/pages/shangpinfenlei/formAdd'
import shangpinxinxiList from '@/views/pages/shangpinxinxi/list'
import shangpinxinxiDetail from '@/views/pages/shangpinxinxi/formModel'
import shangpinxinxiAdd from '@/views/pages/shangpinxinxi/formAdd'
import cartList from '@/views/pages/shop_order/cart'
import addressList from '@/views/pages/shop_address/list'
import zhenweijianbieList from '@/views/pages/zhenweijianbie/list'
import zhenweijianbieDetail from '@/views/pages/zhenweijianbie/formModel'
import zhenweijianbieAdd from '@/views/pages/zhenweijianbie/formAdd'
import order_confirm from '@/views/pages/shop_order/confirm'
import ordersList from '@/views/pages/shop_order/list'

const routes = [{
		path: '/',
		redirect: '/index/home'
	},
	{
		path: '/index',
		component: index,
		children: [{
			path: 'home',
			component: home
		}
		, {
			path: 'yonghuList',
			component: yonghuList
		}, {
			path: 'yonghuDetail',
			component: yonghuDetail
		}, {
			path: 'yonghuAdd',
			component: yonghuAdd
		}
		, {
			path: 'yonghuCenter',
			component: yonghuCenter
		}
		, {
			path: 'shangpinfenleiList',
			component: shangpinfenleiList
		}, {
			path: 'shangpinfenleiDetail',
			component: shangpinfenleiDetail
		}, {
			path: 'shangpinfenleiAdd',
			component: shangpinfenleiAdd
		}
		, {
			path: 'shangpinxinxiList',
			component: shangpinxinxiList
		}, {
			path: 'shangpinxinxiDetail',
			component: shangpinxinxiDetail
		}, {
			path: 'shangpinxinxiAdd',
			component: shangpinxinxiAdd
		}
		, {
			path: 'cartList',
			component: cartList
		}
		, {
			path: 'addressList',
			component: addressList
		}
		, {
			path: 'zhenweijianbieList',
			component: zhenweijianbieList
		}, {
			path: 'zhenweijianbieDetail',
			component: zhenweijianbieDetail
		}, {
			path: 'zhenweijianbieAdd',
			component: zhenweijianbieAdd
		}
		, {
			path: 'order_confirm',
			component: order_confirm
		}
		, {
			path: 'ordersList',
			component: ordersList
		}
		]
	},
	{
		path: '/login',
		component: login
	}
	,{
		path: '/yonghuRegister',
		component: yonghuRegister
	}
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router
