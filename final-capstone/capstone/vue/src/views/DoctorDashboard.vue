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
  </div>

  <!-- include contact support -->
</template>

<script>
import EditOfficeList from '../components/EditOfficeList.vue';


export default {
  name: "doctor-dash",
  components: {EditOfficeList},
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
  display: grid;
   grid-template-columns: 25% 75%;
    grid-template-areas: "nav content";
    min-height: 100vh;
}

#nav {
  grid-area: nav;
  width: 200px;
  background-color:red;
}

#content {
  grid-area: content;
  padding: 20px;
  background-color: coral;
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