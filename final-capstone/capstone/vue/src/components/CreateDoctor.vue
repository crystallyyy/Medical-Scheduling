<template>
  <div>
    <form @submit.prevent="submitForm">
        
      <div id="firstNameFrame" class="form-group">
        <label for="first_name">First Name:&nbsp;&nbsp;</label>
        <input type="text" class="form-control" v-model="firstName" required>
      </div>
      
      <div id="lastNameFrame" class="form-group">
        <label for="last_name">Last Name:&nbsp;&nbsp;</label>
        <input type="text" class="form-control" v-model="lastName" required>
      </div>
      
      <div id="timeSlotFrame" class="form-group">
        <label for="time_slot_default">Time Slot:&nbsp;&nbsp;</label>
        <input type="text" class="form-control" v-model="timeSlotDefault" required>
      </div>
      
      <div id="emailFrame" class="form-group">
        <label for="email">Email:&nbsp;&nbsp;</label>
        <input type="email" class="form-control" v-model="email" required>
      </div>

      <button id="submitButton" type="submit" class="btn btn-primary">Submit</button>
      
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


<style scoped>
h1 {
  text-align: center;
  margin-bottom: 30px;
}

#firstNameFrame {
  display: flex;
  margin-left: 176px;
  margin-bottom: 25px

}

#lastNameFrame {
  display: flex;
  margin-left: 177px;
  margin-bottom: 25px
}

#timeSlotFrame {
  display: flex;
  margin-left: 186px;
  margin-bottom: 25px

}

#emailFrame {
  display: flex;
  margin-left: 215px;
  margin-bottom: 25px
}

/* #submitButton {
  display: flex;
  margin-left: 265px;
  margin-bottom: 25px;
  background-color: #04abcc
}

#submitButton:hover {
  background-color: #048eaa
} */

input[type="text"],
input[type="email"],
input[type="password"] {
  width: 50%;
  padding: 10px;
  margin-bottom: 20px;
  border-radius: 5px;
  border: 1px solid #ccc;
}

input[type="submit"] {
  background-color: #04abcc;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
  width: 50%;
}

input[type="submit"]:hover {
  background-color: #048eaa;
}

</style>


