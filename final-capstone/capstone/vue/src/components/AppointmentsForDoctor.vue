<template>
  <div>
      <div>
           <h2>Upcoming Appointments</h2>
          <ul>
              <li v-for="appointment in appointments" v-bind:key="appointment.appointmentId">
                  <p>Date: {{appointment.apptDate}}</p>
                  <p>Time: {{appointment.startTime}}</p>
                  <p>Duration: {{appointment.duration}}</p>
                  <p>Patient: {{patient.lastName}}, {{patient.firstName}}</p>
                  <p>Contact: {{patient.phoneNumber}}</p>
                  <p>Office: {{office.officeName}}</p>
              </li>
          </ul>
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

<style>

</style>