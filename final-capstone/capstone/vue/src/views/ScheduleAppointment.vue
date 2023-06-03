<template>
  <div class="maindiv">
    <!-- <button> <router-link :to="{name: 'Providers'}"> Find A Provider</router-link></button>
       
    <button>  <router-link :to="{name: 'Offices'}">  Find An Office  </router-link> </button> -->
    
      <b-card no-body class="bcard">
        <b-tabs pills card>
          <b-tab title="Tab 1" active>
            <b-card-text>Tab contents 1
            </b-card-text>
          </b-tab>
          <b-tab title="Tab 2"><b-card-text>Tab contents 2</b-card-text></b-tab>
        </b-tabs>
      </b-card>
 



  </div>
</template>

<script>

import { BCard, BCardText, BTabs, BTab } from 'bootstrap-vue'
export default {
  components: { BCard,
  BCardText,
  BTabs,
  BTab },
  name: "ScheduleAppointment",
};
</script>

<style scoped>
.maindiv{
  background-color: yellow;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
}
b-card {
    display: flex;
    flex-direction: column;
    flex-basis: 50%;
    height: 200px;
    border: 4px black solid;
    background-color: white;
}

b-tab {
  background-color: green;
}

b-card-text {
  background-color: sandybrown;
}



</style>