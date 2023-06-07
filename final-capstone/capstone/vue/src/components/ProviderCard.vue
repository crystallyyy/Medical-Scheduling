<template>
  <div>
    <h2>Dr. {{ doctor.firstName }} {{ doctor.lastName }}</h2>
    <h3>{{ doctor.email }}</h3>
   
   <date-picker v-model="date" :config="options" v-on:click="getTimeSlots(doctor)" ></date-picker>
    <button @click="getAvailabilityByDay"></button>
  </div>
</template>

<script>

import datePicker from 'vue-bootstrap-datetimepicker';
import 'bootstrap/dist/css/bootstrap.css';
import 'pc-bootstrap4-datetimepicker/build/css/bootstrap-datetimepicker.css'
import providerService from "../services/providerService.js";

export default {
  data(){
    return{
      date: new Date(),
      dayOfWeek: '',
       options: {
       format: 'MM/DD/YY',
       useCurrent: false,
     },
   availabilityForThisDoc: []
    }
  },
async created(){
  const response = await providerService.getAvailabilityByDoctor(this.doctor.doctorId)
  this.availabilityForThisDoc = response.data;
},

  props: {
    doctor: Object,
   
  },
  components: {
    datePicker
  },
  methods: {
    getDayOfWeek(){
      const weekday = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];

      const d =new Date(this.date) 
      let day = weekday[d.getDay()];
      this.dayOfWeek = day
      
    },

  

  getAvailabilityByDay(){
    this.getDayOfWeek();

    const foundDay = this.availabilityForThisDoc.find( (availability) => {
      return availability.dayOfWeek.toLowerCase() == this.dayOfWeek.toLowerCase();
    })
    const start = new Date(foundDay.startTime)
    const end = new Date(foundDay.endTime)
    const slots = start.getTime() - end.getTime()
    console.log(slots);
    console.log(Number(foundDay.startTime))
    const hoursInDay = foundDay.endTime.toNumber() - foundDay.startTime.toNumber()
    console.log(hoursInDay)
    const timeSlots = hoursInDay / this.doctor.timeSlotDefault
    console.log(timeSlots)
    
    for(let j =0; j < timeSlots; j++){
            let appointment = {
              doctorId: this.doctor.doctorId,
              apptDate: this.date,
              startTime: foundDay.startTime.plusMinutes(this.doctor.timeSlotDefault),
              duration: this.doctor.timeSlotDefault,
              patientId: null,
              officeId: 0
            }
            return appointment;
    }
    
           // appointmentService.newAppointment(appointment);

            // this.showAppointments(doctor.doctorId, this.date);
          }

    // for(let i = 0; i < this.availabilityForThisDoc.length; i++){
        
        // if(this.dayOfWeek == this.availabilityForThisDoc[i].dayOfWeek){
        //   let endTime = this.availabilityForThisDoc[i].endTime;
        //   let startTime = this.availabilityForThisDoc[i].startTime;
        //   let hoursInDay = endTime - startTime;
        //   let slots = hoursInDay / this.doctor.timeSlotDefault

        //   
        // }
      }

    
    // showAppointments(doctorId, apptDate){
    //   appointmentService.getAppointmentsbyDoctorDate(doctorId, apptDate).then( (response) => {
    //     this.appointmentsToday = response.data;
    //   })
    // },
 
  }

</script>

<style>
</style>