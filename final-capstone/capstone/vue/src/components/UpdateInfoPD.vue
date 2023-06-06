<template>
  <div>
      <div id="patient-info-display">
      <h2>Current Patient Information</h2>
      <p>Name: </p>
      <p>{{patient.firstName}} {{patient.lastName}} </p>
      <p>Date of Birth: </p>
      <p>{{patient.dateOfBirth}} </p>
      <p>Address: </p>
      <p>{{patient.address}} </p>
      <p>Phone Number: </p>
      <p>{{patient.phoneNumber}} </p>
      </div>
      <button>Update Your Personal Information</button>  <!--toggle the form when clicked?-->
      <div id="patient-info-update-form" >
          <label for="firstName">First Name: </label>
          <input type="text" name="firstName" id="firstName" v-model="updatedPatient.firstName" required>
          <label for="lastName">Last Name: </label>
          <input type="text" name="lastName" id="lastName" v-model="updatedPatient.lastName" required>
          <label for="dateOfBirth">Date of Birth: </label>
          <input type="date" name="dateOfBirth" id="dateOfBirth" v-model="updatedPatient.dateOfBirth" required>
          <label for="address_line1">Address Line 1:</label>
          <input type="text" id="address_line1" v-model="address.address_line1" required />
          <label for="address_line2">Address Line 2:</label>
          <input type="text" id="address_line2" v-model="address.address_line2" />
          <label for="city">City:</label>
          <input type="text" id="city" v-model="address.city" required />
          <label for="state">State:</label>
          <input type="text" id="state" v-model="address.state" required />
          <label for="zip_code">Zip Code:</label>
          <input type="text" id="zip_code" v-model="address.zip_code" required />
          <label for="phoneNumber">Phone Number: </label>
          <input type="text" name="phoneNumber" id="phoneNumber" v-model="updatedPatient.phoneNumber">
          <button type="submit" v-on:click="submitForm">Submit</button>
      </div>
  </div>
</template>

<script>
import patientService from '../services/patientService.js'
export default {
name: 'update-info-pd',

data(){
    return{
        patient: {
            firstName: '',
            lastName: '',
            dateOfBirth: '',
            address: '',
            phoneNumber: ''
        },

        updatedPatient: {
            patientId: 0,
            firstName: '',
            lastName: '',
            dateOfBirth: '',
            address: '',
            phoneNumber: ''
        },
         address: {
        address_line1: "",
        address_line2: "",
        city: "",
        state: "",
        zip_code: "",
      },
    }
},

created(){
    const patientId = this.$route.params.patientId
    patientService.getPatientByPatientId(patientId).then( (response) => {
        this.patient.firstName = response.data.firstName;
        this.patient.lastName = response.data.lastName;
        this.patient.dateOfBirth = response.data.dateOfBirth;
        this.patient.address = response.data.address;
        this.patient.phoneNumber = response.data.phoneNumber;
    })
},
methods: {
    submitForm(){
        this.updatedPatient.address = `${this.address.address_line1}, ${this.address.address_line2}, ${this.address.city}, ${this.address.state} ${this.address.zip_code}`;
        this.updatedPatient.patientId = this.$store.state.role.id

        patientService.updatePatientInformation(this.updatedPatient).then( (response) => {
            if(response.status == 200){
               this.updatedPatient = {};
                alert("Patient Information updated")
                this.$router.push({name: 'patientdash',})
            }
        })
    }
}
}
</script>

<style>

</style>