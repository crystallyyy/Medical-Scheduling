<template>
  <div id="main">
    <div id="nav">
      <ul class="nav flex-column">
        <li class="nav-item">
          <img id="img" src="../../img/logo2.jpeg" alt="company logo" />
        </li>
        <li class="nav-item">
          <button type="button" class="btn btn-info" @click="activeCard = 1">
            Dashboard
          </button>
        </li>
        <li class="nav-item">
          <button type="button" class="btn btn-info" @click="activeCard = 2">
            My Profile
          </button>
        </li>
        <li class="nav-item">
          <button type="button" class="btn btn-info" @click="activeCard = 3">
           Manage Locations
          </button>
        </li>
        <li class="nav-item">
          <button type="button" class="btn btn-info" @click="activeCard = 4">
           Manage Availability
          </button>
        </li>
      </ul>
    </div>

    <div id="content">
      <div class="dashboard" v-show="activeCard === 1">
        <h1>Welcome to your Dashboard</h1>
        
      </div>
      <div class="appointments" v-show="activeCard === 2">
       
      </div>
      <div class="info" v-show="activeCard === 3">
       
         <edit-office-list></edit-office-list>
      </div>
      <div class="visits" v-show="activeCard === 4">
        
      </div>
    </div>
    <div class="card card-body" v-show="activeCard === 4">
      Content for change availability
      <doctor-availability></doctor-availability>
    </div>
  </div>

  <!-- include contact support -->
</template>

<script>
import DoctorAvailability from "../components/DoctorAvailability.vue";
import EditOfficeList from '../components/EditOfficeList.vue'
export default {
  name: "doctor-dash",
  components: {EditOfficeList, DoctorAvailability},
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

<style>
#main {
  display: flex;
}

#nav {
  width: 200px;
  background-color: #f1f1f1;
}

.imgdiv {
  padding: 10px;
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
  border: 1px solid #ccc;
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
</style>