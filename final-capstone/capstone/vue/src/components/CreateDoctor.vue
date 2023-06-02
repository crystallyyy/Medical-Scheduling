<template>
  <div>
    <h2>Create Doctor Table</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="first_name">First Name:</label>
        <input type="text" class="form-control" v-model="firstName" required>
      </div>
      
      <div class="form-group">
        <label for="last_name">Last Name:</label>
        <input type="text" class="form-control" v-model="lastName" required>
      </div>
      
      <div class="form-group">
        <label for="time_slot_default">Time Slot Default:</label>
        <input type="text" class="form-control" v-model="timeSlotDefault" required>
      </div>
      
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" class="form-control" v-model="email" required>
      </div>
      
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      firstName: '',
      lastName: '',
      timeSlotDefault: '',
      email: ''
    };
  },
  methods: {
    submitForm() {
      // Handle form submission here
      // You can access the form values using the data properties (e.g., this.doctorId, this.userId, etc.)
      // Execute appropriate logic to create the table and insert the data into the database
    }
  }
};
</script>
