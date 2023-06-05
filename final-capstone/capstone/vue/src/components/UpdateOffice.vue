<template>
  <div>
    <h2>Update Office</h2>
    <form @submit.prevent="submitForm">
      <div>
        <label for="officeName">Office Name:</label>
        <input type="text" id="officeName" v-model="officeName" required />
      </div>
      <div>
        <label for="address">Address:</label>
        <input type="text" id="address" v-model="address" required />
      </div>
      <div>
        <label for="phoneNumber">Phone Number:</label>
        <input type="text" id="phoneNumber" v-model="phoneNumber" required />
      </div>
      <div>
        <button type="submit">Update</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      officeName: "",
      address: "",
      phoneNumber: "",
    };
  },
  methods:{
    submitForm(){
       this.officeName = 'Example Office';
      this.address = '123 Example Street';
      this.phoneNumber = '555-1234';
    }
  }
};
</script>

<style>
</style>