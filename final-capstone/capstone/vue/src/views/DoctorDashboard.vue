<template>
<div id='main'>
    <div id="nav">
      <div class="imgdiv">
          <img id="img" src="../../img/logo2.jpeg" alt="company logo">
      </div>
      <!-- <ul class="nav flex-column">
        <li class="nav-item">
          <button type="button" class="btn btn-info" @click="activeCard = 1">Dashboard</button>

          <img id="img" src="../../img/logo2.jpeg" alt="company logo" />
        </li> -->
        <li class="nav-item">
          <button type="button" class="btn btn-info" @click="activeCard = 1">
            Dashboard
          </button>
        </li>
        <li class="nav-item">
          <button type="button" class="btn btn-info " @click="activeCard = 2">My Profile</button>
        </li>
        <li class="nav-item">
          <button type="button" class="btn btn-info" @click="activeCard = 3">Manage Locations</button>
        </li>
        <li class="nav-item">
          <button type="button" class="btn btn-info" @click="activeCard = 4">Manage Availability</button>
        </li>

      <!-- </ul> -->
    </div>

<div id="content"> 
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

    <div class="card card-body" v-show="activeCard === 4">
      Content for change availability
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

/* #main{
        
        display: grid;
        height: 90vh;
        grid-template-columns: 25% 75%;
        grid-template-areas: "nav content";
        margin: 20px;
        border: 4px solid black;
    }

    #nav{
        grid-area: nav;
        display:flex;
        flex-direction: column;
        height: 100%;
        background-color: #243688;
      
    }

    #content{
        grid-area: content;
        display: flex;
        flex-direction: column;
        align-content: center;
        height: 100%;
        background-color: whitesmoke;
    }
      
    #img {
      max-width: 100px;
      margin-bottom: 20px;
      display: flex;
      margin: auto;
    }

 */

/* #img {
      max-width: 30%;
      margin-bottom: 20px;
    }
    #main{
        display: grid;
        grid-template-columns: 25% 75%;
        grid-template-areas: "nav content";
    }
    #nav{
    grid-area: nav;
    background-color: grey;
    display:flex;
    justify-content: center;
    flex-direction: column;
    align-content: center;
    }
    #content{
      grid-area: content;
        display: flex;
    }
    .imgdiv {
    flex-basis: 25%;
    display: flex;
    justify-content: center;
    align-items: center;
    }

    #nav ul {
  flex-grow: 1;
   list-style-type: none;
   margin: 0;
   padding:0;
   justify-content: center;

    } */
</style>