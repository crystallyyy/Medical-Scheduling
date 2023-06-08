<template>
  <div>
      <div>
          <h2>Upcoming Appointments</h2>
          <ul>
              <li v-for="appointment in appointments" v-bind:key="appointment.appointmentId">
                  <p>Date: {{appointment.apptDate}}</p>
                  <p>Time: {{appointment.startTime}}</p>
                  <p>Duration: {{appointment.duration}}</p>
                  <p>Dr. {{doctor.lastName}}</p>
                  <p>Contact: {{doctor.email}}</p>
                  <p>Office: {{office.officeName}}</p>
              </li>
          </ul>
      </div>
      <button> <router-link :to="{name: 'patientdash', params: {patientId: this.$route.params.patientId}}">Back to Dashboard</router-link> </button>
  </div>
</template>

<script>
import appointmentService from '../services/appointmentService'
import officeService from '../services/officeService'
import providerService from '../services/providerService.js'
export default {
    data(){
        return{
            appointments: [],
            doctor: [],
            office: []
        }
    },
    created(){
        const patientId = this.$route.params.patientId
        appointmentService.getAppointmentsByPatient(patientId).
        then( (response) => {
            this.appointments = response.data;

            this.appointments.forEach(appointment => {
                providerService.getDoctorByDoctorId(appointment.doctorId).then( (res) => {
                    this.doctor = res.data;
                })
                
            });

            this.appointments.forEach( appointment => {
                officeService.getOfficeByOfficeId(appointment.officeId).then( (resp) => {
                    this.office = resp.data
                })
            })
        });

    },

    methods: {
      
    }

}
</script>

<style>

</style>