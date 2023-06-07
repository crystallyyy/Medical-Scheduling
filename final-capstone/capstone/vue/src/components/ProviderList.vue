<template>
  <div>
    <div
      class="one-doctor"
      v-for="doctor in doctors"
      v-bind:key="doctor.doctorId"
    >
      <h2>Dr. {{ doctor.firstName }} {{ doctor.lastName }}</h2>
      <h3>{{ doctor.email }}</h3>
      <h3><button>View Availability</button></h3>
      <ul>
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
           <CalendarWidget @setDate="setDate($event)"/>
    
    </div>
  </div>
</template>

<script>
import appointmentService from "../services/appointmentService.js";
import providerService from "../services/providerService.js";
import CalendarWidget from '../components/CalendarWidget.vue';

export default {
  name: "provider-list",
  components: {
  CalendarWidget
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
      date: '',
      isAvailabilityVisible: false,
      booking: false,
      newAppointment: {
        doctorId: "",
        apptDate: "",
        startTime: "",
        duration: "",
        patientId: "",
        officeId: ""
      },
      availabilities: [],
      doctors: [],
      offices: [],
    };
  },
  methods: {

    setDate(date){
      this.date = date;
      console.log(this.date)
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

    getAvailabilityByDoctorId(doctorId) {
      return this.availabilities.filter((availability) => {
        return availability.doctorId === doctorId;
      });
    },
  },

  computed: {},
};
</script>

<style></style>
