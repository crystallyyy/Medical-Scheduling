<template>
   <form @submit.prevent="submitForm">
    <div id="firstNameFrame">
      <label for="firstName">First Name:&nbsp;&nbsp;</label>
      <input type="text" id="firstName" v-model="formData.firstName" required />
    </div>
    <div id="lastNameFrame">
      <label for="lastName">Last Name:&nbsp;&nbsp;</label>
      <input type="text" id="lastName" v-model="formData.lastName" required />
    </div>
    <div id="dateOfBirthFrame">
      <label for="dateOfBirth">Date of Birth:&nbsp;&nbsp;</label>
      <input type="date" id="dateOfBirth" v-model="formData.dateOfBirth" required />
    </div>
    <div id="phoneNumberFrame">
      <label for="phoneNumber">Phone Number:&nbsp;&nbsp;</label>
      <input type="tel" id="phoneNumber" v-model="formData.phoneNumber" required />
    </div>
    <div id="addressFrame">
      <label for="address">Address:&nbsp;&nbsp;</label>
      <input type="text" id="address" v-model="formData.address" required />
      <label for="city">City:&nbsp;&nbsp;</label>
      <input type="text" id="city" v-model="formData.city" required />
      <label for="state">State:&nbsp;&nbsp;</label>
      <input type="text" id="state" v-model="formData.state" required />
      <label for="zip">ZIP:&nbsp;&nbsp;</label>
      <input type="text" id="zip" v-model="formData.zip" required />
    </div>
    <button id="submitButton" type="submit">Submit</button>
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
      firstName: "",
      lastName: "",
      dateOfBirth: "",
      phoneNumber: "",
      address: "",
      city: "",
      state: "",
      zip: ""
    },
    fetchPatient: {}
    };
  },
  methods: {
    async submitForm() {


      try{
     const res1 = await patientService.getPatientUserIdByUsername(this.userName);
       this.userId = res1.data;
      
      await patientService.getPatientByUserId(this.userId).then(resp => {
        this.fetchPatient = resp.data
        console.log(this.fetchPatient.dateOfBirth);
      })

      this.fetchPatient.firstName = this.formData.firstName;
      this.fetchPatient.lastName = this.formData.lastName;
      this.fetchPatient.dateOfBirth = this.formData.dateOfBirth;
      this.fetchPatient.phoneNumber = this.formData.phoneNumber;
      this.fetchPatient.address = `${this.formData.address}, ${this.formData.city}, ${this.formData.state} ${this.formData.zip}`;
      
      await patientService.updatePatientInformation(this.fetchPatient).then(res=>{
          if(res.status==200){
            this.$router.push({name: 'patientdash', params: {patientId: this.fetchPatient.patientId}});
          }
      })
      
      }catch(error) {
      console.log(error)
      }
     
    },
    resetForm() {
      this.formData = {
      userId: null,
      firstName: "",
      lastName: "",
      dateOfBirth: "",
      address: "",
      city: "",
      state: "",
      zip: ""
    };
    },

  }
};
</script>
 


<style scoped>
.container {
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  padding: 40px;
  width: 400px;
  max-width: 50%;
  margin: 0 auto;
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

#userIdFrame {
  display: flex;
  margin-left: 200px;
  margin-bottom: 25px

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

#dateOfBirthFrame {
  display: flex;
  margin-left: 163px;
  margin-bottom: 25px
}

#addressFrame {
  display: flex;
  margin-left: 196px;
  margin-bottom: 25px
}

#phoneNumberFrame {
  display: flex;
  margin-left: 145px;
  margin-bottom: 25px
}

#submitButton {
  display: flex;
  margin-left: 265px;
  margin-bottom: 25px;
  background-color: #04abcc
}

#submitButton:hover {
  background-color: #048eaa
}

</style>