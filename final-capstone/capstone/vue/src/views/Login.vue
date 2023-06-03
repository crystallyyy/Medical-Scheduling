<template>
  <div id="login">
    <div class="fancy-border">
      <h1>WELCOME TO THE MEDICAL SCHEDULING PORTAL</h1>
      <img src="../../img/logo2.jpeg" alt="company logo">
    </div>
    

    <form class="credentials" @submit.prevent="login">
      <h2 >Sign In</h2>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
    <button type="submit">Sign In</button>
      
    </form>


    <form class="fancy-border">
      <h2 >Create Account</h2> <br>

      <!-- as PATIENT         -->
      <p><router-link :to="{ name: 'patientRegister' }">Patient</router-link> </p><br>
      
      <!-- as PROVIDER         -->
      <p><router-link :to="{ name: 'doctorRegister' }">Provider</router-link> </p>

    </form>


  </div>
</template>

<script>
import authService from "../services/authService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);

          
               this.$router.push("/patientDash"); 
            
            
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}



.fancy-border {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-content: center;
  border: 2px solid #3F51B5; /* Dark blue border */
  border-radius: 10px; /* Rounded corners */
  padding: 10px;
  background-color: white; /* Light gray background */

}

.fancy-border h2 {
  margin: 0 0 10px;
}

.fancy-border p {
  margin: 0;
}

.form{
  margin-left: auto;
  margin-right: auto;
  width: 50%; /* Adjust the width as needed */
  
  text-align: center;
}
 
 img {
   max-width: 10%;
 }
</style>