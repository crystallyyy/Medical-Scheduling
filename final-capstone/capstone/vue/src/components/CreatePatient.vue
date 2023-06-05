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
.container {
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  padding: 40px;
  width: 400px;
  max-width: 50%;
  margin: 0 auto;
}

h1 {
  text-align: center;
  margin-bottom: 30px;
}

input[type="text"],
input[type="email"],
input[type="password"] {
  width: 50%;
  padding: 10px;
  margin-bottom: 20px;
  border-radius: 5px;
  border: 1px solid #ccc;
}

input[type="submit"] {
  background-color: #04abcc;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
  width: 50%;
}

input[type="submit"]:hover {
  background-color: #048eaa;
}
</style>