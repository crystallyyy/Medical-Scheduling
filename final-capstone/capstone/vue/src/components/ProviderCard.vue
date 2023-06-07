<template>
  <div>
    <h2>Dr. {{ doctor.firstName }} {{ doctor.lastName }}</h2>
    <h3>{{ doctor.email }}</h3>
    <ul>
      <li
        v-for="availability in getAvailabilityByDoctorId(doctor.doctorId)"
        v-bind:key="availability.dayOfWeek"
      >
        <h3><button>View Availability</button></h3>
        <p>
          {{ availability.dayOfWeek }}: {{ availability.startTime }}-{{
            availability.endTime
          }}
        </p>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  props: {
    doctor: Object,
    availabity: Object,
  },
};
</script>

<style>
</style>