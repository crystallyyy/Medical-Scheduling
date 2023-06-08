<template>
  <div id="login">
    <div class="header">
      <h1><strong>GENESIS MEDICAL SCHEDULING PORTAL</strong></h1>
      <img class="image" src="../../img/logo2.jpeg" alt="company logo" />
    </div>

    <form class="credentials" @submit.prevent="login">
      <h2><strong>Sign In</strong></h2>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input
          type="text"
          id="username"
          v-model="user.username"
          required
          autofocus
        />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit">Sign In</button>
    </form>

    <form class="createAccount">
      <h2><strong>Create Account</strong></h2>
      <br />
      <button type="submit">
        <router-link class="patientButton" :to="{ path: '/patientRegistration'}"
          >PATIENT</router-link
        ></button
      ><br />
      <button type="submit">
        <router-link class="providerButton" :to="{ path: '/doctorRegistration'}"
          >PROVIDER</router-link
        >
      </button>
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
      invalidCredentials: false,
    };
  },
  methods: {
    push() {
              
            if(this.$store.state.role.role === 'ROLE_ADMIN'){
                  this.$router.push({name: "doctordash", params: {doctorId : this.$store.state.role.id}}); 
               }
           if(this.$store.state.role.role === 'ROLE_USER'){    
                     this.$router.push({name: "patientdash", params: {patientId : this.$store.state.role.id}}); 
            
           }
    },
 async login() {
    await authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);

             authService.getRole(this.user.username)
              .then(response => {
                const roles = response.data;
                this.$store.commit("SET_ROLE", roles);
                console.log("login" +this.$store.state.role.role);
                console.log(this.$store.state.role.role === 'ROLE_ADMIN');
              });

            
          }
          setTimeout(()=>{
            this.push();
          },2000)
           
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
#login {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  font-family: Arial, sans-serif;
  background-color: #f2f2f2;
}

.header {
  width: 400px;
  max-width: 100%;
  padding: 2rem;
  background-color: #ffffff;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  margin-bottom: 1rem;
}

h1 {
  font-size: 24px;
  margin-bottom: 0.5rem;
}

.image {
  max-width: 100px;
  height: auto;
  margin: auto;
  display: flex;
  justify-content: center;
  align-items: center;
}

.credentials,
.fancy-border {
  width: 400px;
  max-width: 100%;
  padding: 2rem;
  background-color: #ffffff;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  margin-bottom: 1rem;
}

.createAccount {
  width: 400px;
  max-width: 100%;
  padding: 2rem;
  background-color: #ffffff;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  margin-bottom: 1rem;
  text-align: center;
}

.createAccount button {
  margin-bottom: 1rem;
  font-size: 16px;
  font-weight: bold;
}

.credentials h2,
.fancy-border h2,
.createAccount h2 {
  margin-bottom: 1rem;
  text-align: center;
  font-size: 20px;
}

.form-input-group {
  margin-bottom: 1rem;
}

form input {
  width: 100%;
  padding: 10px;
  margin-bottom: 10px;
  border-radius: 5px;
  border: 1px solid #cccccc;
  font-size: 16px;
}

button {
  background-color: #04abcc;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
  width: 100%;
}

button:hover {
  background-color: #048eaa;
}

.alert {
  background-color: #f8d7da;
  color: #721c24;
  border: 1px solid #f5c6;
}

.patientButton {
  color: white;
  display: flex;
  justify-content: center;
}

.providerButton {
  color: white;
  display: flex;
  justify-content: center;
}
</style>