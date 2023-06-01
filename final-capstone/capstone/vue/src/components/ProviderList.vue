<template>
  <div>
    <ul>
      <li v-for="doctor in doctors" v-bind:key="doctor.doctorId">
        <h2>Dr. {{ doctor.firstName }} {{ doctor.lastName }}</h2>
        <h3>{{ doctor.email }}</h3>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "provider-list",
  data() {
    return {
      doctors: [
        {
          doctorId: 1,
          userId: 1,
          firstName: "crys",
          lastName: "alma",
          timeSlot: 30,
          email: "no@email.com",
        },
        {
          doctorId: 2,
          userId: 2,
          firstName: "nate",
          lastName: "anin",
          timeSlot: 60,
          email: "no@email.com",
        },
        {
          doctorId: 3,
          userId: 3,
          firstName: "jon",
          lastName: "jung",
          timeSlot: 45,
          email: "no@email.com",
        },
        {
          doctorId: 4,
          userId: 4,
          firstName: "erica",
          lastName: "buck",
          timeSlot: 20,
          email: "no@email.com",
        },
      ],
    };
  },
};
</script>

<style>
</style>