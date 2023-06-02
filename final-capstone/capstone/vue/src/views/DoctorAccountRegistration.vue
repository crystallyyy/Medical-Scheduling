<template>
   <div> 
        <h1>Welcome, Doctor Please Create An Account!</h1>
        <create-doctor :userName="username"/>
    </div>
</template>

<script>
import CreateDoctor from '../components/CreateDoctor.vue'
export default {
  components: { CreateDoctor },
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