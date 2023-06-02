<template>
  <div>
    <ul v-show="isAvailabilityVisible">
      <li
        v-for="availability in getAvailabilityByDoctorId(doctor.doctorId)"
        v-bind:key="availability.dayOfWeek"
      >
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
  name: "doctor-availability",
  data() {
    return {
      isAvailabilityVisible: false,
    };
  },
};
</script>

<style>
</style>