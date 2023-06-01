<template>
  <div id="app">
    
    <div id="newNav">
      
    </div>
    
  
    <div id="nav">
      <ul>
        
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
        <li><router-link v-bind:to="{name: 'login'}" v-show="$store.state.token === ''">Login</router-link></li>&nbsp;&nbsp;
        <li><router-link v-bind:to="{ name: 'doctordash' }">Doctor Dashboard</router-link></li>&nbsp;&nbsp;
        <li><router-link v-bind:to="{ name: 'patientdash' }">Patient Dashboard</router-link></li>&nbsp;&nbsp;
        <li> <router-link :to="{name: 'logout'}" v-show="$store.state.token != ''"> Logout</router-link> </li>&nbsp;&nbsp;
        <li> <router-link :to="{name: 'login'}" v-show="false">Register</router-link> </li>
      </ul>
    </div>

    
    <router-view />
  </div>
</template>
<script>

export default {
  name: 'app'
}
</script>
<style scoped>
#nav {
  display: flex;
  margin-left: auto;
  margin-right: auto;
  width: 50%; /* Adjust the width as needed */
  text-align: center;
  justify-content: center;
}
#nav ul{
  display: flex;
  list-style-type: none;
  
}
</style>