<template>
  <div>
    <ul>
      <li v-for="office in offices" v-bind:key="office.officeId">
        <h2>Dr. {{ office.officeName }} </h2>
        <h3>{{ office.address }}</h3>
        <h3> {{office.phoneNumber}}</h3>
      </li>
    </ul>
  </div>
</template>

<script>
import officeService from "../services/officeService.js";

export default {
    name: 'office-list',
    data() {
      return {
        offices : []
      }
    },
    created() {
      officeService.getAllOffices()
        .then((response) => {
          this.offices = response.data;
        });
      
  }
}
</script>

<style>

</style>