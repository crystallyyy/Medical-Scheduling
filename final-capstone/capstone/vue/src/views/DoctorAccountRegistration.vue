<template>
  <create-doctor :user="user"/>
</template>

<script>
import CreateDoctor from '../components/CreateDoctor.vue'
export default {
  components: { CreateDoctor },
  props: ['user'],

}
</script>

<style>

</style>