<template>
  <div id="main">
    <div id="nav">
      <li class="nav-item">
        <img class="nav-item" id="img" src="../../img/logo2.jpeg" alt="company logo" />
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

    <!-- <ul class="nav flex-column">
        <li class="nav-item">
          <button type="button" class="btn btn-info" @click="activeCard = 1">Dashboard</button>

          <img id="img" src="../../img/logo2.jpeg" alt="company logo" />
        </li> -->

    <!-- <div id="content"> 
    <div class="card card-body" v-show="activeCard === 1">
          Content for show dashboard
    </div>
    <div class="card card-body" v-show="activeCard === 2">
          Content for my profile
    </div>  
    <div class="card card-body" v-show="activeCard === 3">
          Content for manage location
    </div>
    <div class="card card-body" v-show="activeCard === 4">
          Content for change availability
    </div> 
</div> -->

    <div id="content">
      <div class="dashboard" v-show="activeCard === 1">
        <h1 id="dashboardMessage">Welcome to your Dashboard</h1>
      </div>

      <div class="myProfile" v-show="activeCard === 2">
        
      </div>

      <div class="info" v-show="activeCard === 3">
        <edit-office-list></edit-office-list>
      </div>

      <div class="visits" v-show="activeCard === 4"></div>

      <div class="card card-body" v-show="activeCard === 4">
        <!-- Content for change availability -->
        <doctor-availability></doctor-availability>
      </div>
    </div>
  </div>

  <!-- include contact support -->
</template>

<script>
import DoctorAvailability from "../components/DoctorAvailability.vue";
import EditOfficeList from "../components/EditOfficeList.vue";
export default {
  name: "doctor-dash",
  components: { EditOfficeList, DoctorAvailability },
  data() {
    return {
      activeCard: null,
      methods: {},
    };
  },
};
</script>


<style scoped>
/* #main {
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

#nav-item {
  padding: 10px;
  justify-content: center;
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
} */

#main {
  display: grid;
   grid-template-columns: 25% 75%;
    grid-template-areas: "nav content";
    min-height: 100vh;
}

#nav {
  grid-area: nav;
  width: 200px;
  /* background-color:red; */
}

#content {
  grid-area: content;
  padding: 20px;
  /* background-color: coral; */
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
</style>