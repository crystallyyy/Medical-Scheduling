<template>
  <div>
    <h3 class="offices">OFFICES</h3>

    <div class='actions'>
      <router-link v-bind:to="{ name: 'patientdash' }">
        Return to Patient Dashboard
      </router-link>
      <span style="paddingLeft: 8px; paddingRight: 8px;"></span>
     
    </div>


    <table class="officeTable">
      <thead>
        <tr>
          <th>Office Name</th>
          <th>Address</th>
          <th>Phone Number</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="office in offices" v-bind:key="office.officeId">
          <td>{{ office.officeName }}</td>
          <td>{{ office.address }}</td>
          <td>{{ office.phoneNumber }}</td>
          <td>
            <button>
              <router-link :to="{ name: 'reviewsPD', params: { officeId: office.officeId }}">
                <strong>See reviews for this office</strong>
              </router-link>
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import officeService from "../services/officeService.js";

export default {
  name: "office-list",
  data() {
    return {
      offices: [],
    };
  },
  created() {
    officeService.getAllOffices().then((response) => {
      this.offices = response.data;
    });
  },
};
</script>

<style>

.actions {
  margin-left: auto;
  margin-right: auto;
  margin-top: 20px;
  margin-bottom: 20px;
  width: 50%; 
  text-align: center;
}


h3 {
  margin-left: auto;
  margin-right: auto;
  margin-top: 20px;
  margin-bottom: 20px;
  width: 50%; 
  text-align: center;
  
}

.officeTable {
  margin-left: auto;
  margin-right: auto;
  width: 80%;
  text-align: center;
}

.officeTable th,
.officeTable td {
  padding: 10px;
}

.officeTable th {
  background-color: #f2f2f2;
}

.officeTable tbody tr:nth-child(even) {
  background-color: #f9f9f9;
}

.officeTable tbody tr:hover {
  background-color: #e6e6e6;
}

button {
  background-color: #e6e6e6;
  color: white;
  border: none;
  padding: 5px 10px;
  cursor: pointer;
}

button:hover {
  background-color: #e6e6e6;
}
</style>