import Vue from 'vue';
import VueRouter from 'vue-router';
import DoctorDashboard from '../views/DoctorDashboard.vue';
import PatientDashboard from '../views/PatientDashboard.vue';
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Offices from '../views/Offices.vue'
import Providers from '../views/Providers.vue'
import Register from '../views/Register.vue'
import ScheduleAppointment from '../views/ScheduleAppointment.vue'
import PatientRegistration from '../views/PatientRegistration.vue'
import DoctorUserRegistration from '../views/DoctorUserRegistration.vue'
import DoctorAccountRegistration from '../views/DoctorAccountRegistration.vue'
import store from '../store/index'
import Home from '../views/Home.vue'
import ReviewsOnPD from '../views/ReviewsOnPD.vue'
import ReviewsOnDD from '../views/ReviewsOnDD.vue'
import AddReview from '../views/AddReview.vue'

Vue.use(VueRouter);

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

 const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      // meta: {
      //   requiresAuth: true
      // }
    },
    {
      path: '/doctorDash',
      name: 'doctordash',
      component: DoctorDashboard,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/patientDash',
      name: 'patientdash',
      component: PatientDashboard,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/login',
      name: 'login',
      component: Login
      
    },
    {
      path: '/patientRegistration',
      name: 'patientRegister',
      component: PatientRegistration,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/doctorRegistration',
      name: 'doctorRegister',
      component: DoctorUserRegistration,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/scheduleAppointment',
      name: 'schedule-appointment',
      component: ScheduleAppointment,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/providers',
      name: 'Providers',
      component: Providers,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/offices',
      name: 'Offices',
      component: Offices,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/logout',
      name: 'logout',
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/register',
      name: 'register',
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/reviews/:officeId',
      name: 'reviewsPD',
      component: ReviewsOnPD,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/reviews/:officeId',
      name: 'reviewsDD',
      component: ReviewsOnDD,
      meta: {
        requiresAuth: false
      },
    },
    {
      path: '/reviews/:officeId/addReview',
      name: 'add-review',
      component: AddReview,
      meta: {
        requiresAuth: false
      },
    },
    {

      path: '/doctor-account-creation',
      name: 'DoctorAccountCreationPage',
      component: DoctorAccountRegistration,
      meta: {
        requiresAuth: false
      },
      props: true
    }
  ]

  });
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
