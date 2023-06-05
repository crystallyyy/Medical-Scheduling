<template>
  <div>
    <h2>Current Availability</h2>
    <ul >
      <li
        v-for="availability in availabilities"
        v-bind:key="availability.dayOfWeek"
      >
        <p>
          {{ availability.dayOfWeek }}: {{ availability.startTime }}-{{
            availability.endTime
          }}
        </p>
      </li>
    </ul>
    <button>Update Availability</button> 
   <div id="update-availability-form">
     
     <input type="checkbox" value="Monday" id="monday" v-model="daysOfWeek" >Monday
     <input type="checkbox" value="Tuesday" id="tuesday" v-model="daysOfWeek">Tuesday
     <input type="checkbox" value="Wednesday" id="wednesday" v-model="daysOfWeek">Wednesday
     <input type="checkbox" value="Thursday" id="thursday" v-model="daysOfWeek">Thursday
     <input type="checkbox" value="Friday" id="friday" v-model="daysOfWeek">Friday
     <label for="Monday">(start time - end time) </label>

     <input type="time" v-model="updatedAvailability.startTime">
     <input type="time" v-model="updatedAvailability.endTime">
    <button type="submit" v-on:click="updateAvailability"> Submit </button>
   </div>
  </div>
</template>

<script>
import providerService from '../services/providerService';
export default {
  name: "doctor-availability",
  data() {
    return {
      isAvailabilityVisible: false,
      availabilities: [], 
      daysOfWeek: [],
      updatedAvailability: 
        {
          doctorId: 0,
          dayOfWeek: '',
          startTime: '',
          endTime: ''
        }
      
    }
 
  },
  methods: {
    updateAvailability(){
      for (let i =0; i < this.daysOfWeek.length; i++){
        if(this.daysOfWeek[i] == 'Monday'){
          this.updatedAvailability.doctorId = 2
          this.updatedAvailability.dayOfWeek = 'monday'
          providerService.updateDocAvailability(this.updatedAvailability).then( (response) => {
            console.log(response.statusText)
          })
        }else  if(this.daysOfWeek[i] == 'Tuesday'){
          this.updatedAvailability.doctorId = this.$route.params.doctorId;
          this.updatedAvailability.dayOfWeek = 'tuesday'
          providerService.updateDocAvailability(this.updatedAvailability)
        } else  if(this.daysOfWeek[i] == 'Wednesday'){
          this.updatedAvailability.doctorId = this.$route.params.doctorId;
          this.updatedAvailability.dayOfWeek = 'wednesday'
          providerService.updateDocAvailability(this.updatedAvailability)
        } else  if(this.daysOfWeek[i] == 'Thursday'){
          this.updatedAvailability.doctorId = this.$route.params.doctorId;
          this.updatedAvailability.dayOfWeek = 'Thursday'
          providerService.updateDocAvailability(this.updatedAvailability)
        } else  if(this.daysOfWeek[i] == 'Friday'){
          this.updatedAvailability.doctorId = this.$route.params.doctorId;
          this.updatedAvailability.dayOfWeek = 'Friday'
          providerService.updateDocAvailability(this.updatedAvailability)
        } 
      }
      alert("Your availability has been updated");
    }
  },
   created(){
    const currentDoctorId = this.$route.params.doctorId;

     providerService.getAvailabilityByDoctor(currentDoctorId).then( (response) => {
       this.availabilities = response.data;
     })
   }
};
</script>

<style>
</style>