<template>
  <div>
      <div>
          <h2>Upcoming Appointments</h2>
          <ul>
              <li v-for="appointment in appointments" v-bind:key="appointment.appointmentId">
                  <p>{{appointment.apptDate}}</p>
                  <p>{{appointment.startTime}}</p>
                  <p>{{appointment.duration}}</p>
                  <p>Dr. {{doctor.lastName}}</p>
                  <p>{{doctor.email}}</p>
              </li>
          </ul>
      </div>
  </div>
</template>

<script>
import appointmentService from '../services/appointmentService'
import providerService from '../services/providerService.js'
export default {
    data(){
        return{
            appointments: [],
            doctor: []
        }
    },
    created(){
        const patientId = this.$route.params.patientId
        appointmentService.getAppointmentsByPatient(patientId).then( (response) => {
            this.appointments = response.data;

            this.appointments.array.forEach(appointment => {
                providerService.getDoctorByDoctorId(appointment.doctorId).then( (res) => {
                    this.doctor = res.data;
                })
                
            });
        });

    },

    methods: {
      
    }

}
</script>

<style>

</style>