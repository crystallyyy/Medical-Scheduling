<template>
  <div>
    <h3>FIND A PROVIDER</h3>
    <div class="actions">
      <router-link v-bind:to="{ name: 'patientDash' }">
        Return to Dashboard
      </router-link>
    </div>
   
   
   



    <provider-list></provider-list>
  </div>
</template>

<script>
import ProviderList from "../components/ProviderList.vue";
export default {
  components: {
    ProviderList,
  },
};
</script>

<style scoped>
.button {
  display: inline-block;
  justify-self: center;
}
.mt-2 {
  padding: 0;
  list-style: none;
}

.card-text {
  padding: 10px;
  text-align: center;
}
</style>