<template>
  <div>
      <div >
           <h2 id="header">Upcoming Appointments</h2>

           <table>
              <thead>
                  <th>Date</th>
                  <th>Time</th>
                  <th>Duration</th>
                  <th>Patient</th>
                  <th>Contact</th>
                  <th>Office</th>
              </thead>
              <tbody>
                  <tr v-for="appointment in appointments" v-bind:key="appointment.appointmentId"> 
                      <td>{{appointment.apptDate}}</td>
                      <td>{{appointment.startTime}}</td>
                      <td>{{appointment.duration}}</td>
                      <td>{{patient.lastName}}, {{patient.firstName}}</td>
                      <td>{{patient.phoneNumber}}</td>
                      <td>{{office.officeName}}</td>
                  </tr>
              </tbody>
          </table>
       
      </div>
      <div id="button"> 
      <button > <router-link :to="{name: 'doctordash', params: {patientId: this.$route.params.doctorId}}">Back to Dashboard</router-link> </button>
    </div>
  </div>
</template>

<script>
import appointmentService from '../services/appointmentService.js'
import patientService from '../services/patientService.js'
import officeService from '../services/officeService.js'

export default {
name: 'appointments-for-doctor',
data(){
    return{
        appointments: [],
        patient: [],
        office: []
    }
},
created(){
    const doctorId = this.$route.params.doctorId
    appointmentService.getAppointmentsByDoctor(doctorId).then( (response) => {
        this.appointments = response.data;

        this.appointments.forEach( appointment => {
            patientService.getPatientByPatientId(appointment.patientId).then( (res) => {
                this.patient = res.data;
            });

        this.appointments.forEach( appointment => {
            officeService.getOfficeByOfficeId(appointment.officeId).then( (resp) => {
                this.office = resp.data;
            })
        } )
        })
    })
}
}
</script>

<style scoped>
#header{
    text-align: center;
    margin: 30px;
}
/* #list{
    list-style: none;
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: center;
   
}
#list-item{
     margin-bottom: 20px;
} */
#button{
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>