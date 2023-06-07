<template>
   <div> 
        <h1>Doctor Account Details</h1>
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
h1 {
  text-align: center;
  margin-top: 30px;
  margin-bottom: 30px;
}
</style>