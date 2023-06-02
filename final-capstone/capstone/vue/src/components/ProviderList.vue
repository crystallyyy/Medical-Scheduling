<template>
  <div>
    <div class="one-doctor" v-for="doctor in doctors" v-bind:key="doctor.doctorId">
   
        <h2>Dr. {{ doctor.firstName }} {{ doctor.lastName }}</h2>
        <h3>{{ doctor.email }}</h3>
        <h3> <button v-on:click.prevent="isAvailabilityVisible = true"
        > View Availability </button>
        </h3>
       <doctor-availability></doctor-availability>
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
        <select id="office-id" v-model="newAppointment.officeId">
          <option v-for="office in getOfficesByDoctorId(doctor.doctorId)" v-bind:key="office.officeId" :value="office.officeId"> {{office.officeName}} </option>
        </select>
        <button type="submit" >Submit</button>
      </form>
      </div> -->
    </div>
  </div>
</template>

<script>
import officeService from '../services/officeService.js'
import appointmentService from '../services/appointmentService.js'
import providerService from '../services/providerService.js'
import DoctorAvailability from '../components/DoctorAvailability.vue'

export default {
  name: "provider-list",
  components: {
    DoctorAvailability
  },
   created() {
      providerService.getAllProviders()
        .then((response) => {
          this.doctors = response.data;
        });
      
  }, 
  data() {
    return {
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
      appointments : [],
    doctors: [],
  //{
//           doctorId: 1,
//           userId: 1,
//           firstName: "crys",
//           lastName: "alma",
//           timeSlot: 30,
//           email: "no@email.com",
//         },
//         {
//           doctorId: 2,
//           userId: 2,
//           firstName: "nate",
//           lastName: "anin",
//           timeSlot: 60,
//           email: "no@email.com",
//         },
//         {
//           doctorId: 7,
//           userId: 3,
//           firstName: "jon",
//           lastName: "jung",
//           timeSlot: 45,
//           email: "no@email.com",
//         },
//         {
//           doctorId: 8,
//           userId: 4,
//           firstName: "erica",
//           lastName: "buck",
//           timeSlot: 20,
//           email: "no@email.com",
//         },

      availabilities: [
        {
          doctorId: 1,
          dayOfWeek: 'Monday',
          startTime: '9am',
          endTime: '5pm'
        },
         {
          doctorId: 1,
          dayOfWeek: 'Tuesday',
          startTime: '9am',
          endTime: '5pm'
        },
         {
          doctorId: 1,
          dayOfWeek: 'Wednesday',
          startTime: '9am',
          endTime: '5pm'
        },
         {
          doctorId: 2,
          dayOfWeek: 'Monday',
          startTime: '9am',
          endTime: '5pm'
        },
         {
          doctorId: 3,
          dayOfWeek: 'Monday',
          startTime: '9am',
          endTime: '5pm'
        }
      ],
      offices: []
    };
  },
  methods: {
    getAvailabilityByDoctorId(doctorId){
      return this.availabilities.filter( (availability) => {
        return availability.doctorId === doctorId;
      })
    },

    getOfficesByDoctorId(doctorId){
      officeService.getOfficesByDoctorId(doctorId).then( (response) => {
        this.offices = response.data;
      })
    },

  //TODO: CREATE APPT CONTROLLER
    saveAppt(doctor){
      this.newAppointment.doctorId = doctor.doctorId;
      this.newAppointment.duration = doctor.timeSlot;
      appointmentService.addAppointment(this.newAppointment).then( (response) => {
        if(response.status == 201)
        this.$router.push({name: 'patientDash'})
      })
    },

  },
};
</script>

<style>
</style>