<template>
   <div> 
        <h1>Welcome, User Please Create An Account!</h1>
        <create-patient :userName="username"/>
    </div>
</template>

<script>

import CreatePatient from '../components/CreatePatient.vue';
export default {
  components: { CreatePatient },
data() {
    return {
      username: ''
    };
  },
  created() {
    this.username = this.$route.query.username;
  }
  

}
</script>

<style>

</style>