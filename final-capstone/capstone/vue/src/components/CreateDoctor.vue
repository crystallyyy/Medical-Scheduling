<template>
  <div>
    <form @submit.prevent="submitForm">
        
      <div class="form-group">
        <label for="first_name">First Name:</label>
        <input type="text" class="form-control" v-model="firstName" required>
      </div>
      
      <div class="form-group">
        <label for="last_name">Last Name:</label>
        <input type="text" class="form-control" v-model="lastName" required>
      </div>
      
      <div class="form-group">
        <label for="time_slot_default">Time Slot Default:</label>
        <input type="text" class="form-control" v-model="timeSlotDefault" required>
      </div>
      
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" class="form-control" v-model="email" required>
      </div>

      <button type="submit" class="btn btn-primary">Submit</button>
      
    </form>

  </div>
</template>

<script>
import providerService from "../services/providerService.js";
export default {
    props :{
        userName: String
    },
  data() {
    return {
      firstName: '',
      lastName: '',
      timeSlotDefault: '',
      email: '',
      userId: 0,
      doctor: {},
    };
  },
  methods: {
    async submitForm() { 
          try {
    const res1 = await providerService.getDoctorUserIdByUsername(this.userName);
    this.userId = res1.data;
    const res2 = await providerService.getDoctorByUserId(this.userId);
    this.doctor = res2.data; 
    this.doctor.firstName = this.firstName;
    this.doctor.lastName = this.lastName;
    this.doctor.email = this.email;
    this.doctor.timeSlotDefault = this.timeSlotDefault;
    providerService.updateDoctorInformation(this.doctor).then(res=>{
      if(res.status==200){
        this.$router.push({name: 'doctordash', params: {doctorId: this.doctor.doctorId}})
      }
    })
       } catch (error) {
    // Handle any errors that occur during the async calls
    console.error(error);
  }
   
    },
    created(){
      
   
    }
  }
};
</script>


