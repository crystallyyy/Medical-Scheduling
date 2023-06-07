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
    
      <provider-card :doctor="doctor" :availabity="getAvailabilityByDoctorId(doctor.doctorId)"/>
    


          
          
     

      <scheduling-calendar></scheduling-calendar>
      <!-- v-on:click.prevent="isAvailabilityVisible = true" -->
      <!-- <button v-b-b-toggle></button> -->
      <!-- <div> Book A Time
      <form  action="POST">
        <label for="appt-date">Date: </label>
        <input type="date" id="appt-date" v-model="newAppointment.apptDate">
        <label for="start-time">Time: </label>
        <input type="time" id="start-time" v-model="newAppointment.startTime">
        <label for="patient-id">Patient Id: </label>
        <input type="text" id="patient-id" v-model.number="newAppointment.patientId">
        <label for="office-id">Office: </label>
       
        <button type="submit" >Submit</button>
      </form>
      </div> -->
    </div>
  </div>
</template>

<script>
import appointmentService from "../services/appointmentService.js";
import providerService from "../services/providerService.js";
import CalendarWidget from '../components/CalendarWidget.vue';
import ProviderCard from './ProviderCard.vue';

export default {
  name: "provider-list",
  components: {
  CalendarWidget,
    ProviderCard
  },

  created() {

    providerService.getAllProviders().then((response) => {
      this.doctors = response.data;

      // this.doctors.forEach((doctor) => {

      //   officeService.getOfficesByDoctorId(doctor.doctorId).then((response) => {
      //     this.doctor.offices = response.data
          
        
        
     
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
