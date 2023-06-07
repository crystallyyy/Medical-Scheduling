<template>
  <form @submit="submitForm">
    <div id="userIdFrame">
      <label for="userId">User ID:&nbsp;&nbsp;</label>
      <input type="number" id="userId" v-model="formData.userId" required />
    </div>
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
    <div id="addressFrame">
      <label for="address">Address:&nbsp;&nbsp;</label>
      <textarea id="address" v-model="formData.address" required></textarea>
    </div>
    <div id="phoneNumberFrame">
      <label for="phoneNumber">Phone Number:&nbsp;&nbsp;</label>
      <input type="tel" id="phoneNumber" v-model="formData.phoneNumber" required />
    </div>
    <button id="submitButton" type="submit">Submit</button>
    <button id="submitButton" @click="showUserId"> Click Me</button>
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
      }
    };
  },
  methods: {
    async submitForm() {
     await console.log((await patientService.getPatientUserIdByUsername(this.userName)).data)
      
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
   async showUserId(){
      console.log(this.userName)
    }
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