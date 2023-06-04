          
<template>
    <div id="main">
        <div id="nav">
            <ul class="nav flex-column">

                <li class="nav-item"> <img id="img" src="../../img/logo2.jpeg" alt="company logo">
                    
                </li>
                <li class="nav-item">
                    <button type="button" class="btn btn-info" @click="activeCard = 1">Dashboard</button>

                </li>
                <li class="nav-item">
                    <button type="button" class="btn btn-info " @click="activeCard = 2">Appointments</button>
                </li>
                <li class="nav-item">
                    <button type="button" class="btn btn-info" @click="activeCard = 3">Update Info</button>
                </li>
                <li class="nav-item">
                    <button type="button" class="btn btn-info" @click="activeCard = 4">Past Visits</button>
                </li>

            </ul>
        </div>

        <div id="content"> 
            <div class="dashboard" v-show="activeCard === 1">
                <h1>Welcome to your Dashboard</h1>
                <patient-quicklinks></patient-quicklinks>
            </div>
            <div class="appointments" v-show="activeCard === 2">
                <schedule-appointment></schedule-appointment>
            </div>  
            <div class="info" v-show="activeCard === 3">
                Content for manage location
            </div>
            <div class="visits" v-show="activeCard === 4">
                Content for change availability
            </div> 
        </div>
    </div>
    
  <!-- include contact support -->
  
</template>

<script>
import PatientQuicklinks from '../components/PatientQuicklinks.vue'
import ScheduleAppointment from "./ScheduleAppointment.vue"

export default {
  name: "doctor-dash",
  components: { ScheduleAppointment, PatientQuicklinks },
  data() {
    return {

    activeCard: 1,
    methods:{
    // showProviders(){
    //     this.$router.push("/")
    // }

     } 
    }
  }
}
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
  display: none;
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
    } */
</style>