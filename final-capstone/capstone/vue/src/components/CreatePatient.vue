<template>
  <form @submit.prevent="submitForm">
    <div>
      <label for="firstName">First Name:</label>
      <input type="text" id="firstName" v-model="formData.firstName" required />
    </div>
    <div>
      <label for="lastName">Last Name:</label>
      <input type="text" id="lastName" v-model="formData.lastName" required />
    </div>
    <div>
      <label for="dateOfBirth">Date of Birth:</label>
      <input type="date" id="dateOfBirth" v-model="formData.dateOfBirth" required />
    </div>
    <div>
      <label for="address">Address:</label>
      <textarea id="address" v-model="formData.address" required></textarea>
    </div>
    <div>
      <label for="phoneNumber">Phone Number:</label>
      <input type="tel" id="phoneNumber" v-model="formData.phoneNumber" required />
    </div>
    <button type="submit">Submit</button>
  </form>
</template>

<script>
import patientService from "../services/patientService.js";
export default {
    props :{
        userName: String
    },
  data() {
    return {
      formData: {
        userId: null,
        firstName: '',
        lastName: '',
        dateOfBirth: '',
        address: '',
        phoneNumber: ''
      },
      fetchPatient : {},
    };
  },
  methods: {
    async submitForm() {


      try{
     const res1 = await patientService.getPatientUserIdByUsername(this.userName);
       this.userId = res1.data;
      console.log(this.userId);
       const res2 =  await patientService.getPatientByUserId(this.userId)
       this.fetchPatient = res2.data
      console.log(this.fetchPatient);
      }catch(error) {
      console.log(error)
      }
     
    },
    resetForm() {
      this.formData = {
        userId: null,
        firstName: '',
        lastName: '',
        dateOfBirth: '',
        address: '',
        phoneNumber: ''
      };
    },

  }
};
</script>
 


<style>
.container {
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  padding: 40px;
  width: 400px;
  max-width: 50%;
  margin: 0 auto;
}

h1 {
  text-align: center;
  margin-bottom: 30px;
}

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