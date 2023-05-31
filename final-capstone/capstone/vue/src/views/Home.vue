<template>
  <div class="home">
    <h1>Home</h1>
    
    <router-link v-bind:to="{name: 'add'}">Add New Patient</router-link>

    <p>You must be authenticated to see this</p>

    <div>

    </div>
  </div>
</template>

<script>
import service from '../services/ServerService.js';

export default {
  name: "home",
  data() {
    return {

      patientList : []

    }
  },

  created() {
    service.getAllPatients().then(
      // anonymous function
      (response) => {
        this.patientList = response.data;
      }
    );
  }
};
</script>

<style>
</style>