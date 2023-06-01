<template>
  <div class="home">
    <!-- <h1>Home</h1> -->
    <div class="fancy-border">
      <h1>WELCOME TO THE MEDICAL SCHEDULING PORTAL</h1>
      <h2>GIT TEST </h2>
      <img src="image.jpg" alt="Fancy Portal Image">
      <img src="image.jpg" alt="cool image">
    </div>

    <div >
      <!-- <router-link class="fancy-border" >Add New Patient</router-link> -->
    </div>
    <!-- <p>You must be authenticated to see this</p> -->
    <div>

    </div>
  </div>
</template>

<script>
import serverService from '../services/serverService.js';

export default {
  name: "home",
  data() {
    return {
      patientList : []
    }
  },

  created() {
    serverService.getAllPatients().then(
      // anonymous function
      (response) => {
        this.patientList = response.data;
      }
    );
  }
};
</script>

<style>
body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
  display: flex;
}

/* Header */
.header {
  background-color: #3F51B5; /* Dark blue */
  color: #FFFFFF; /* White text */
  padding: 20px;
}

.header h1 {
  margin: 0;
}

/* Sidebar */
.sidebar {
  width: 30%;
  background-color: #F5F5F5; /* Light gray */
  padding: 20px;
}

/* Main content area */
.content {
  width: 70%;
  padding: 20px;
}

/* Footer */
.footer {
  background-color: #3F51B5; /* Dark blue */
  color: #FFFFFF; /* White text */
  padding: 20px;
  text-align: center;
}

.footer p {
  margin: 0;
}






.fancy-border {
  border: 2px solid #3F51B5; /* Dark blue border */
  border-radius: 10px; /* Rounded corners */
  padding: 20px;
  background-color: #F5F5F5; /* Light gray background */

  margin-left: auto;
  margin-right: auto;
  width: 50%; /* Adjust the width as needed */

  text-align: center;

}

.fancy-border h2 {
  margin: 0 0 10px;
}

.fancy-border p {
  margin: 0;
}



.router-link {
  margin-left: auto;
  margin-right: auto;
  width: 50%; 

  text-align: center;

}



</style>