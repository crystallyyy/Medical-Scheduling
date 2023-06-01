import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import DoctorDashboard from '../views/DoctorDashboard.vue';
import PatientDashboard from '../views/PatientDashboard.vue';


Vue.use(VueRouter);

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const routes = [{
  
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/doctorDash',
      name: 'doctordash',
      component: DoctorDashboard
      
    },
    {
      path: '/patientDash',
      name: 'patientdash',
      component: PatientDashboard
      
    }
  ];

  const router = new VueRouter({
    mode: 'history',
    routes
  });
  



export default router;
