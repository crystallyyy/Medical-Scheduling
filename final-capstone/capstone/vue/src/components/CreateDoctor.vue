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
    submitForm() {
        providerService.getDoctorUserIdByUsername(this.userName).then(res=>{
            this.userId = res.data
            console.log(this.userId);
        });

        providerService.getDoctorByUserId(this.userId).then(res=>{
            this.doctor = res.data;
            console.log(this.doctor.timeSlotDefault)
        })


    
    }
  }
};
</script>
