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
        <button
          id="nav-item"
          type="button"
          class="btn btn-info"
          @click="activeCard = 1"
        >
          Dashboard
        </button>
      </li>
      <li class="nav-item">
        <button
          id="nav-item"
          type="button"
          class="btn btn-info"
          @click="activeCard = 2"
        >
          My Profile
        </button>
      </li>
      <li class="nav-item">
        <button
          id="nav-item"
          type="button"
          class="btn btn-info"
          @click="activeCard = 3"
        >
          Manage Locations
        </button>
      </li>
      <li class="nav-item">
        <button
          id="nav-item"
          type="button"
          class="btn btn-info"
          @click="activeCard = 4"
        >
          Manage Availability
        </button>
      </li>
    </div>

    <div id="content">
      <div class="dashboard" v-show="activeCard === 1">
        <h1 id="dashboardMessage">Welcome to your Dashboard</h1>
        <doctor-quicklinks></doctor-quicklinks>

      </div>

      <div class="myProfile" v-show="activeCard === 2">
        
      </div>

      <div class="info" v-show="activeCard === 3">
        <edit-office-list></edit-office-list>
       </div>
      <div class="visits" v-show="activeCard === 4"></div>

      <div class="card card-body" v-show="activeCard === 4">
          <doctor-availability></doctor-availability>        
      </div>

    </div>
  </div>

  <!-- include contact support -->
</template>

<script>
import DoctorAvailability from "../components/DoctorAvailability.vue";
import DoctorQuicklinks from "../components/DoctorQuicklinks.vue";
import EditOfficeList from "../components/EditOfficeList.vue";
export default {
  name: "doctor-dash",
  components: { EditOfficeList, DoctorAvailability, DoctorQuicklinks },
  data() {
    return {
     activeCard: null,
      methods: {},
    };
  },
};
</script>


<style scoped>
#main {
  display: grid;
  grid-template-columns: 25% 75%;
  grid-template-areas: "nav content";
  min-height: 100vh;
}

#nav {
  grid-area: nav;
  width: 200px;
}

#content {
  grid-area: content;
  padding: 20px;
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

h1 {
  text-align: center;
}
</style>