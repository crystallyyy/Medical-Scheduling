<template>
  <div>
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
  props : {
      user: Object 
  },
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
  
    }
  }
};
</script>
