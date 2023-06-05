<template>
  <div>
    <!-- <b-container class="bv-example-row"> -->
      <!-- <b-row> -->
        <!-- <b-col> -->
          <div>
            <b-card no-body>
              <b-tabs pills card align="center">
                <b-tab title="Search For Provider" active><providers></providers></b-tab>
                <b-tab title="Search By Location"><b-card-text><offices></offices></b-card-text></b-tab>
              </b-tabs>
            </b-card>
          </div>
        <!-- </b-col> -->
      <!-- </b-row> -->
    <!-- </b-container> -->
  </div>
</template>


<script>
import Providers from '../views/Providers.vue';
import Offices from './Offices.vue';


export default {
  components: {Providers, Offices },
  name: "ScheduleAppointment",
  data() {
    return {
      showTab2: true,
    };
  },
};
</script>

<style scoped>
/* .bv-example-row {
  background-color: #4edbf7;
} */
</style>