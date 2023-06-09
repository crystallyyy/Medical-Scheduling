<template>
  <div id="app">
    <div id="newNav">      
    </div>

    <div id="nav">
      <ul id="navContainer">
        <router-link class="links" v-bind:to="{ name: 'home' }" >HOME</router-link>
        <router-link class="links" v-bind:to="{name: 'login'}" v-show="$store.state.token === ''">LOGIN</router-link>
        <router-link class="links" v-bind:to="{ name: 'doctordash',params: {doctorId: role.roleId} }" v-show="$store.state.token != '' && role.role=='ROLE_ADMIN'">DOCTOR</router-link>
        <router-link class="links" v-bind:to="{ name: 'patientdash',params: {patientId: role.roleId} }" v-show="$store.state.token != '' && role.role=='ROLE_USER'">PATIENT</router-link>
        <router-link class="links" :to="{name: 'logout'}" v-show="$store.state.token != ''"> LOGOUT</router-link>
        <router-link class="links" :to="{name: 'login'}" v-show="false">REGISTER</router-link>
      </ul>
    </div>
   
    <router-view />
  </div>
</template>
<script>


export default {
  
  name: 'app',
  components: {},
  data(){
    return {
      role: this.$store.state.role
    }
  }
}
</script>


<style scoped>

#navContainer {
  padding-left: 0;
  margin-left: 0
}

#nav {
  display: flex;
  padding-left: 1.5em;
  margin-right: auto;
  margin-bottom: auto;
  width: 100%;
  background-color: white;
  background-color: #04abcc;
  text-align: center;
  font-size: 21px;
  font-weight: 525;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  padding: 22px;
  padding-top: auto;
  padding-bottom: auto;
}

.links {
  color:white;
  margin: 0 0.5em;
}

#nav ul{
  display: flex;
  align-content: center;
}

</style>