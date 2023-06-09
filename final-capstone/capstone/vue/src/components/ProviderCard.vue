<template>
  <div class="card">
    <div class="card-body">
      <h5 class="card-title">
        Dr. {{ doctor.firstName }} {{ doctor.lastName }}
      </h5>
      <date-picker v-model="date" :config="options"></date-picker>

      <div id="appt buttons" v-show="showTimeSlotButtons">
        <button
          id="timeSlotButtons"
          v-for="n in NumSlots"
          :key="n"
          @click="handleTimeSlotClick(n)"
          :class="{ selected: n === selectedSlot }"
        >
          {{ formatTime(selectedDate.getTime() + n * 30 * 60 * 1000) }}
        </button>
      </div>
      <div v-show="viewOffices">
        <select
          v-model="selectedOffice"
          v-if="doctorOffices.length > 0"
          @change="showSubmitButton()"
        >
          <option
            v-for="office in doctorOffices"
            :value="office.officeId"
            :key="office.value"
          >
            {{ office.officeName }}
          </option>
        </select>
        <p v-else>Loading offices...</p>
        <p v-if="doctorOffices.length > 0">
          Selected office: {{ selectedOffice }}
        </p>
      </div>
      <p class="card-text" v-show="showNoAvailability">No Availability Today</p>
      <p class="card-text" v-show="appointmentCreationError">
        Problems creating this Appointment
      </p>
      <p>{{date}}</p>
      <a
        class="btn btn-primary"
        @click="getAvailabilityByDay()"
        v-show="readyToSubmit == false"
        >View Availability</a
      >
      <a
        class="btn btn-primary"
        @click="bookAppointMent()"
        v-show="readyToSubmit"
        >Book Appointment</a
      >
    </div>
  </div>
</template>

<script>
import datePicker from "vue-bootstrap-datetimepicker";
import "bootstrap/dist/css/bootstrap.css";
import "pc-bootstrap4-datetimepicker/build/css/bootstrap-datetimepicker.css";
import providerService from "../services/providerService.js";
import officeService from "../services/officeService.js";
import appointmentService from "../services/appointmentService.js";

export default {
  data() {
    return {
      date: new Date(),
      dayOfWeek: "",
      options: {
        format: "MM/DD/YYYY",
        useCurrent: false,
      },
      availabilityForThisDoc: [],
      showNoAvailability: false,
      showTimeSlotButtons: false,
      NumSlots: 0,
      docAppointmentsToday: [],
      selectedDateTime: new Date(),
      doctorOffices: [],
      viewOffices: false,
      selectedOffice: null,
      selectedSlot: null,
      readyToSubmit: false,
      appointmentCreationError: false,
    };
  },
  async created() {
    const response = await providerService.getAvailabilityByDoctor(
      this.doctor.doctorId
    );
    this.availabilityForThisDoc = response.data;

    const res2 = await officeService.getOfficesByDoctorId(this.doctor.doctorId);
    this.doctorOffices = res2.data;
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
        const hoursInDay = Number(endHour) - Number(startHour);
        this.NumSlots = hoursInDay * 2 - 1;

        this.selectedDate = new Date(this.date);
        this.selectedDate.setHours(Number(startHour));
        this.selectedDate.setMinutes(0);
        this.selectedDate.setSeconds(0);
      } else {
        this.showNoAvailability = true;
        this.showTimeSlotButtons = false;
      }
    },
    formatTime(timestamp) {
      const date = new Date(timestamp);
      let hours = date.getHours();
      let minutes = date.getMinutes();

      const period = hours >= 12 ? "PM" : "AM";
      hours = hours % 12 || 12;
      minutes = minutes.toString().padStart(2, "0");

      return `${hours}:${minutes} ${period}`;
    },
    handleTimeSlotClick(n) {
      this.viewOffices = true;
      const selectedTime = this.selectedDate.getTime() + n * 30 * 60 * 1000;
      this.selectedDateTime = new Date(selectedTime);
      this.selectedSlot = n;
      console.log(this.selectedDateTime);
    },
    showSubmitButton() {
      this.readyToSubmit = true;
    },
    bookAppointMent() {
      const appt = {
        doctorId: this.doctor.doctorId,
        apptDate: this.selectedDateTime.toISOString().split("T")[0],
        startTime: this.selectedDateTime
          .toLocaleTimeString("en-US", {
            timeZone: "America/New_York",
            hour12: false,
          })
          .slice(0, 8),
        duration: 30,
        patientId: this.$store.state.role.roleId,
        officeId: this.selectedOffice,
      };
      appointmentService.addAppointment(appt).then((res) => {
        if (res.status == 200) {
          alert("Your appointment has been scheduled.");
          location.reload();
        }
      }).catch(error => {
        alert("Could not book appointment")
        console.error(error)
      })
    },
  },

  // showAppointments(doctorId, apptDate){
  //   appointmentService.getAppointmentsbyDoctorDate(doctorId, apptDate).then( (response) => {
  //     this.appointmentsToday = response.data;
  //   })
  // },
};
</script>

<style>
.selected {
  background-color: #00ccff;
  color: white;
}
</style>
