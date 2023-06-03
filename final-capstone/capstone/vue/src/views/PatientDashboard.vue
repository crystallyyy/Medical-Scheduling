          
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
                    <button type="button" class="btn btn-info " @click="activeCard = 2">Schedule an appointment</button>
                </li>
                <li class="nav-item">
                    <button type="button" class="btn btn-info" @click="activeCard = 3">Update info</button>
                </li>
                <li class="nav-item">
                    <button type="button" class="btn btn-info" @click="activeCard = 4">Past visits</button>
                </li>

            </ul>
        </div>

        <div id="content"> 
            <div class="dashboard" v-show="activeCard === 1">
                <h1>Welcome to your dashboard!</h1>
                <patient-quicklinks></patient-quicklinks>
            </div>
            <div class="appointments" v-show="activeCard === 2">
                <schedule-appointment></schedule-appointment>
            </div>  
            <div class="info" v-show="activeCard === 3">
                <b-calendar v-model="value" @context="onContext" locale="en-US"></b-calendar>
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
    
    
  
    #main{
        
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
        background-color: grey;
        
        
    }
    #content{
        grid-area: content;
        display: flex;
        flex-grow: 1;
        flex-direction: column;
        align-content: center;
        height: 100%;
        background-color: yellowgreen;
    }

    #content div{
      
    }
      #img {
      max-width: 100px;
      margin-bottom: 20px;
    }
</style>