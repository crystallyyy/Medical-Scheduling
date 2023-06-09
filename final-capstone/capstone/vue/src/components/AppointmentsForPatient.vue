<template>
  <div>
      <div>
          <h2 id="header">Upcoming Appointments</h2>
          <table>
              <thead>
                  <th>Date</th>
                  <th>Time</th>
                  <th>Duration</th>
                  <th>Doctor</th>
                  <th>Contact</th>
                  <th>Office</th>
              </thead>
              <tbody>
                  <tr v-for="appointment in appointments" v-bind:key="appointment.appointmentId"> 
                      <td>{{appointment.apptDate}}</td>
                      <td>{{appointment.startTime}}</td>
                      <td>{{appointment.duration}}</td>
                      <td>{{doctor.lastName}}</td>
                      <td>{{doctor.email}}</td>
                      <td>{{office.officeName}}</td>
                  </tr>
              </tbody>
          </table>
          
      </div>
      <div id="button">
      <button> <router-link :to="{name: 'patientdash', params: {patientId: this.$route.params.patientId}}">Back to Dashboard</router-link> </button>
      </div>
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

<style scoped>
#header{
    text-align: center;
    margin: 30px;
}
#button{
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>