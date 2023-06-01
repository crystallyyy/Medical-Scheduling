import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import PatientRegistration from '../views/PatientRegistration.vue'
import DoctorRegistration from '../views/DoctorRegistration.vue'
import store from '../store/index'
import ScheduleAppointment from '../views/ScheduleAppointment.vue'
import Providers from '../views/Providers.vue'
import Offices from '../views/Offices.vue'
import PatientDashboard from '../views/PatientDashboard.vue'
import DoctorDashboard from '../views/DoctorDashboard.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/patientregister",
      name: "patientRegister",
      component: PatientRegistration,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/doctorregister",
      name: "doctorRegister",
      component: DoctorRegistration,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/scheduleAppointment",
      name: "schedule-appointment",
      component: ScheduleAppointment,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/providers",
      name: "Providers",
      component: Providers,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/offices",
      name: "Offices",
      component: Offices,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/doctorDash',
      name: 'doctor-dash',
      component: DoctorDashboard,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/patientDash',
      name: 'patient-dash',
      component: PatientDashboard,
      meta: {
        requiresAuth: false
      }
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
