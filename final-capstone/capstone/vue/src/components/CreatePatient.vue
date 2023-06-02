<template>
  <div>
    <form @submit.prevent="submitForm">
      <label for="first_name">First Name:</label>
      <input
        type="text"
        id="first_name"
        v-model="patient.first_name"
        required
      />
      <br />

      <label for="last_name">Last Name:</label>
      <input type="text" id="last_name" v-model="patient.last_name" required />
      <br />

      <label for="date_of_birth">Date of Birth:</label>
      <input
        type="date"
        id="date_of_birth"
        v-model="patient.date_of_birth"
        required
      />
      <br />

      <label for="address_line1">Address Line 1:</label>
      <input
        type="text"
        id="address_line1"
        v-model="address.address_line1"
        required
      />
      <br />

      <label for="address_line2">Address Line 2:</label>
      <input type="text" id="address_line2" v-model="address.address_line2" />
      <br />

      <label for="city">City:</label>
      <input type="text" id="city" v-model="address.city" required />
      <br />

      <label for="state">State:</label>
      <input type="text" id="state" v-model="address.state" required />
      <br />

      <label for="zip_code">Zip Code:</label>
      <input type="text" id="zip_code" v-model="address.zip_code" required />
      <br />

      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script>
export default {
  props: {
    userName: String,
  },
  data() {
    return {
      patient: {
        user_id: null,
        first_name: "",
        last_name: "",
        date_of_birth: "",
        address: "",
      },
      address: {
        address_line1: "",
        address_line2: "",
        city: "",
        state: "",
        zip_code: "",
      },
    };
  },
  methods: {
    async submitForm() {
      this.patient.address = `${this.address.address_line1}, ${this.address.address_line2}, ${this.address.city}, ${this.address.state} ${this.address.zip_code}`;
    },
  },
};
</script>


<style>
</style>