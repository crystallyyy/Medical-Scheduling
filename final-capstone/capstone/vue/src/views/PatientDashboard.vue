          
<template>
  <div id="main">
    <div id="nav">
      <li class="nav-item">
        <img
          class="nav-item"
          id="img"
          src="../../img/logo2.jpeg"
          alt="company logo"
        />
      </li>
      <li class="nav-item">
        <button type="button" class="btn btn-info" @click="activeCard = 1">
          Dashboard
        </button>
      </li>
      <li class="nav-item">
        <button type="button" class="btn btn-info" @click="activeCard = 2">
          Appointments
        </button>
      </li>
      <li class="nav-item">
        <button type="button" class="btn btn-info" @click="activeCard = 3">
          Update Info
        </button>
      </li>
      <li class="nav-item">
        <button type="button" class="btn btn-info" @click="activeCard = 4">
          Past Visits
        </button>
      </li>

    </div>
    <div id="content">
      <div class="dashboard" v-show="activeCard === 1">
        <h1 id="dashboardMessage">Welcome to your Dashboard</h1>
        <patient-quicklinks></patient-quicklinks>
      </div>
      <div class="appointments" v-show="activeCard === 2">
        <schedule-appointment></schedule-appointment>
      </div>
      <div class="info" v-show="activeCard === 3">
        <UpdateInfoPD/>
      </div>
      <div class="visits" v-show="activeCard === 4">
        
      </div>
    </div>
    </div>
</template>

<script>
import PatientQuicklinks from "../components/PatientQuicklinks.vue";
import ScheduleAppointment from "./ScheduleAppointment.vue";
import UpdateInfoPD from '../components/UpdateInfoPD.vue'

export default {
  name: "doctor-dash",
  components: { ScheduleAppointment, PatientQuicklinks, UpdateInfoPD },
  data() {
    return {
      activeCard: 1,
      methods: {
        // showProviders(){
        //     this.$router.push("/")
        // }
      },
    };
  },
};
</script>

<style >
#main {
  display: flex;
}

#nav {
  width: 200px;
  background-color: #f1f1f1;
}

.imgdiv {
  padding: 10px;
  text-align: center;
}

#img {
  width: 100%;
}

.nav {
  padding: 0;
  list-style: none;
}

.nav-item {
  padding: 10px;
  text-align: center;
}

.btn {
  width: 100%;
}

#content {
  flex: 1;
  padding: 20px;
}

.card {
  margin-bottom: 10px;
  border-radius: 5px;
}

.card-body {
  padding: 10px;
  background-color: #fff;
  justify-content: center;
}

.card-body.show {
  display: block;
}

#dashboardMessage {
  margin-top: 30px;
  margin-bottom: 30px;
}

.nav-item {
  list-style: none;
}
</style>