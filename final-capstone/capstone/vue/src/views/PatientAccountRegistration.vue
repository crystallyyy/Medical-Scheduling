<template>
   <div> 
        <h1>Patient Account Details</h1>
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
h1 {
  text-align: center;
  margin-top: 30px;
  margin-bottom: 30px;
}

</style>