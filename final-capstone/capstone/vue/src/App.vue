<template>
  <div id="app">
    <div id="newNav">      
    </div>

    <div id="nav">
      <ul>
        <router-link v-bind:to="{ name: 'home' }" >HOME</router-link>&nbsp;&nbsp;&nbsp;&nbsp;
        <li><router-link v-bind:to="{name: 'login'}" v-show="$store.state.token === ''">LOGIN</router-link></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <li><router-link v-bind:to="{ name: 'doctordash' }" v-show="$store.state.token != ''">DOCTOR</router-link></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <li><router-link v-bind:to="{ name: 'patientdash' }" v-show="$store.state.token != ''" >PATIENT</router-link></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <li> <router-link :to="{name: 'logout'}" v-show="$store.state.token != ''"> LOGOUT</router-link> </li>&nbsp;&nbsp;&nbsp;
        <li> <router-link :to="{name: 'login'}" v-show="false">REGISTER</router-link> </li>
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
  margin-bottom: auto;
  width: 100%;
  background-color: white;
  /* color: white; */
  /* background-color: #243688; */
  text-align: center;
  font-size: 21px;
  font-weight: 525;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  padding: 22px;
  padding-top: auto;
  padding-bottom: auto;

}

#nav ul{
  display: flex;
  list-style-type: none;
  margin-left: auto;
  margin-right: auto;
  width: 100%;
  text-align: center;
  justify-content: center;
}

</style>