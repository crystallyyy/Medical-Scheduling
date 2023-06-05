<template>
  <div id="app">
    <div id="newNav">      
    </div>

    <div id="nav">
      <ul>
        <router-link class="links" v-bind:to="{ name: 'home' }" >HOME</router-link>&nbsp;&nbsp;&nbsp;&nbsp;
        <router-link class="links" v-bind:to="{name: 'login'}" v-show="$store.state.token === ''">LOGIN</router-link>&nbsp;&nbsp;&nbsp;&nbsp;
        <router-link class="links" v-bind:to="{ name: 'doctordash' }" v-show="$store.state.token != ''">DOCTOR</router-link>&nbsp;&nbsp;&nbsp;&nbsp;
        <router-link class="links" v-bind:to="{ name: 'patientdash' }" v-show="$store.state.token != ''" >PATIENT</router-link>&nbsp;&nbsp;&nbsp;&nbsp;
        <router-link class="links" :to="{name: 'logout'}" v-show="$store.state.token != ''"> LOGOUT</router-link>&nbsp;&nbsp;&nbsp;&nbsp;
        <router-link class="links" :to="{name: 'login'}" v-show="false">REGISTER</router-link>
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
  padding-left: 1.5em;
  margin-right: auto;
  margin-bottom: auto;
  width: 100%;
  background-color: white;
  /* color: white; */
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
}

#nav ul{
  display: flex;
  align-content: center;
  margin-left: 3.5em;
  /* padding: none;
  display: flex; */
  /* list-style-type: none; */
  /* margin-left: auto;
  margin-right: auto; */
  /* width: 100%; */
  /* text-align: center; */
  /* justify-content: flex-end; */

}

/* #nav ul li {
  display: inline-block;
  width: 100px;
  background-color: red
} */

/* how can I style this so that the buttons on top are always aligned correctly (2 buttons vs 5 buttons)? */
</style>