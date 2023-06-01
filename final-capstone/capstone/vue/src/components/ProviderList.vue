<template>
  <div>
    <div class="one-doctor" v-for="doctor in doctors" v-bind:key="doctor.doctorId">
   
        <h2>Dr. {{ doctor.firstName }} {{ doctor.lastName }}</h2>
        <h3>{{ doctor.email }}</h3>
        <h3> <button v-on:click.prevent="isAvailabilityVisible = true"
        > View Availability </button>
        </h3>
       
        
          <ul v-show="isAvailabilityVisible">
            <li v-for="availability in getAvailabilityByDoctorId(doctor.doctorId)" v-bind:key="availability.dayOfWeek" >
              <p>{{availability.dayOfWeek}}: {{availability.startTime}}-{{availability.endTime}}</p>
               
            </li>
          </ul>
       
     <button v-b-b-toggle>Book A Time</button>
     <div>
      <form  action="POST">
        <label for="appt-date">Date: </label>
        <input type="date" id="appt-date" v-model="newAppointment.apptDate">
        <label for="start-time">Time: </label>
        <input type="time" id="start-time" v-model="newAppointment.startTime">
        <label for="patient-id">Patient Id: </label>
        <input type="text" id="patient-id" v-model.number="newAppointment.patientId">
        <label for="office-id">Office: </label>
        <input type="text" id="office-id" v-model="newAppointment.officeId">
        <button type="submit" >Submit</button>
      </form>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: "provider-list",
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
      doctors: [{
          doctorId: 1,
          userId: 1,
          firstName: "crys",
          lastName: "alma",
          timeSlot: 30,
          email: "no@email.com",
        },
        {
          doctorId: 2,
          userId: 2,
          firstName: "nate",
          lastName: "anin",
          timeSlot: 60,
          email: "no@email.com",
        },
        {
          doctorId: 3,
          userId: 3,
          firstName: "jon",
          lastName: "jung",
          timeSlot: 45,
          email: "no@email.com",
        },
        {
          doctorId: 4,
          userId: 4,
          firstName: "erica",
          lastName: "buck",
          timeSlot: 20,
          email: "no@email.com",
        },
],
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
      ]
    };
  },
  methods: {
    getAvailabilityByDoctorId(doctorId){
      return this.availabilities.filter( (availability) => {
        return availability.doctorId === doctorId;
      })
    },

    // saveAppt(doctor){
    //   this.newAppointment.doctorId = doctor.doctorId;
    //   this.newAppointment.duration = doctor.timeSlot;
    //   // this.appointments.push(this.newAppointment); or commit to $store
    // },

  },

};
</script>

<style>
</style>