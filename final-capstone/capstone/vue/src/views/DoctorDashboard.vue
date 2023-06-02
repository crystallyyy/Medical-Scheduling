<template>
<div id='main'>
    <div id="nav">
<ul class="nav flex-column">

    <li class="nav-item"> <img id="img" src="../../img/logo.jpg" alt="company logo">
        
</li>
  <li class="nav-item">
    <button type="button" class="btn btn-info" @click="activeCard = 1">Dashboard</button>

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

</ul>
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
</div>
    
  <!-- include contact support -->
  
</template>

<script>
export default {
  name: "doctor-dash",
  data() {
    return {

    activeCard: null,
    methods:{

     } 
    }
  }
}
</script>

<style scoped>
    .navbar {
      height: 100vh;
    }
    .nav-item {
      margin-bottom: 10px;
    }
    #img {
      max-width: 100px;
      margin-bottom: 20px;
    }
    #main{
        display: grid;
        grid-template-columns: 25% 75%;
        grid-template-areas: "nav content";
    }
    #nav{
        display:flex;
    }
    #content{
        display: flex;
    }
</style>