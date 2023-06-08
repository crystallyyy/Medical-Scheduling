<template>
  

    <div class="card">
 
  <div class="card-body">
    <h5 class="card-title">Dr. {{ doctor.firstName }} {{ doctor.lastName }}</h5>
    <date-picker v-model="date" :config="options"></date-picker>

 <div id="appt buttons" v-show="showTimeSlotButtons">
      <button id="timeSlotButtons" v-for="n in NumSlots" :key="n">
        {{ selectedDate.getHours() }} : {{ selectedDate.getMinutes() }}
      </button>
    </div>
    <p class="card-text" v-show="showNoAvailability">No Availability Today</p>
    <a class="btn btn-primary" @click="getAvailabilityByDay()">View Availability</a>
  </div>
</div>
    
    
   

   
  
   

  

</template>

<script>
import datePicker from "vue-bootstrap-datetimepicker";
import "bootstrap/dist/css/bootstrap.css";
import "pc-bootstrap4-datetimepicker/build/css/bootstrap-datetimepicker.css";
import providerService from "../services/providerService.js";

//import appointmentService from '../services/appointmentService.js';

export default {
  data() {
    return {
      date: new Date(),
      dayOfWeek: "",
      options: {
        format: "MM/DD/YY",
        useCurrent: false,
      },
      availabilityForThisDoc: [],
      showNoAvailability: false,
      showTimeSlotButtons: false,
      NumSlots: 0,
      docAppointmentsToday: [],
      selectedDate: new Date(),
    };
  },
  async created() {
    const response = await providerService.getAvailabilityByDoctor(
      this.doctor.doctorId
    );
    this.availabilityForThisDoc = response.data;
  },

  props: {
    doctor: Object,
  },
  components: {
    datePicker,
  },
  methods: {
    getDayOfWeek() {
      const weekday = [
        "Sunday",
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
      ];
      const d = new Date(this.date);
      let day = weekday[d.getDay()];
      this.dayOfWeek = day;
    },

    getAvailabilityByDay() {
      this.getDayOfWeek();

      const foundDay = this.availabilityForThisDoc.find((availability) => {
        return (
          availability.dayOfWeek.toLowerCase() == this.dayOfWeek.toLowerCase()
        );
      });

      if (foundDay) {
        this.showNoAvailability = false;
        this.showTimeSlotButtons = true;
        const [startHour] = foundDay.startTime.split(":");
        const [endHour] = foundDay.endTime.split(":");
        const minutesInDay = Number(endHour) * 60 - Number(startHour) * 60;
        this.NumSlots = Math.floor(minutesInDay / this.doctor.timeSlotDefault);

        console.log(this.NumSlots);
        this.selectedDate = new Date(this.date);
        this.selectedDate.setMinutes(0);
        this.selectedDate.setSeconds(0);
        this.selectedDate.setHours(Number(startHour));
      } else {
        this.showNoAvailability = true;
        this.showTimeSlotButtons = false;
      }

      // appointmentService.newAppointment(appointment);

      // this.showAppointments(doctor.doctorId, this.date);
    },

    // for(let i = 0; i < this.availabilityForThisDoc.length; i++){

    // if(this.dayOfWeek == this.availabilityForThisDoc[i].dayOfWeek){
    //   let endTime = this.availabilityForThisDoc[i].endTime;
    //   let startTime = this.availabilityForThisDoc[i].startTime;
    //   let hoursInDay = endTime - startTime;
    //   let slots = hoursInDay / this.doctor.timeSlotDefault

    //
    // }
  },

  // showAppointments(doctorId, apptDate){
  //   appointmentService.getAppointmentsbyDoctorDate(doctorId, apptDate).then( (response) => {
  //     this.appointmentsToday = response.data;
  //   })
  // },
};
</script>

<style>
</style>