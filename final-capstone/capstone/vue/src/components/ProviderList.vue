<template>
  <div>
    <div
      class="one-doctor"
      v-for="doctor in doctors"
      v-bind:key="doctor.doctorId"
    >
      <provider-card :doctor="doctor" />
    </div>
  </div>
</template>

<script>
import appointmentService from "../services/appointmentService.js";
import providerService from "../services/providerService.js";

import ProviderCard from "./ProviderCard.vue";

export default {
  name: "provider-list",
  components: {
    ProviderCard,
  },

  created() {
    providerService.getAllProviders().then((response) => {
      this.doctors = response.data;
    });

    providerService.getAllAvailabilities().then((response) => {
      this.availabilities = response.data;
    });
  },
  data() {
    return {
      
      booking: false,
      // newAppointment: {
      //   doctorId: "",
      //   apptDate: "",
      //   startTime: "",
      //   duration: "",
      //   patientId: "",
      //   officeId: ""
      // },
      availabilities: [],
      doctors: [],
      
    };
  },
  computed: {
    setDay() {
      return this.date.getDay();
    },
  },
  methods: {
   
    showAppointments(doctorId, apptDate) {
      appointmentService
        .getAppointmentsbyDoctorDate(doctorId, apptDate)
        .then((response) => {
          this.appointmentsToday = response.data;
        });
    },

    //TODO: CREATE APPT CONTROLLER
    saveAppt(doctor) {
      this.newAppointment.doctorId = doctor.doctorId;
      this.newAppointment.duration = doctor.timeSlot;
      appointmentService
        .addAppointment(this.newAppointment)
        .then((response) => {
          if (response.status == 201)
            this.$router.push({ name: "patientDash" });
        });
    },


  },
};
</script>

<style></style>
