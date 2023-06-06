<template>
  <div>
    <h2>Current Availability</h2>
    <ul>
      <li
        v-for="availability in availabilities"
        v-bind:key="availability.dayOfWeek"
      >
        <p>
          {{ availability.dayOfWeek }}: {{ availability.startTime }}-{{
            availability.endTime
          }}
        </p>
      </li>
    </ul>

    <div id="availabilityButton">
      <button class="button">Update Availability</button>
    </div>

    <div id="update-availability-form">
      <input
        type="checkbox"
        value="Monday"
        id="monday"
        v-model="daysOfWeek"
      /> &nbsp; Monday &nbsp;&nbsp;
      <input
        type="checkbox"
        value="Tuesday"
        id="tuesday"
        v-model="daysOfWeek"
      /> &nbsp; Tuesday &nbsp;&nbsp;
      <input
        type="checkbox"
        value="Wednesday"
        id="wednesday"
        v-model="daysOfWeek"
      /> &nbsp; Wednesday &nbsp;&nbsp;
      <input
        type="checkbox"
        value="Thursday"
        id="thursday"
        v-model="daysOfWeek"
      /> &nbsp; Thursday &nbsp;&nbsp;
      <input
        type="checkbox"
        value="Friday"
        id="friday"
        v-model="daysOfWeek"
      /> &nbsp; Friday &nbsp;&nbsp;
    </div>
    <div id="timer">
      <p>
        Start Time &nbsp;<input
          type="time"
          v-model="updatedAvailability.startTime"
        />
      </p>
      &nbsp;&nbsp;&nbsp;

      <p>
        End Time &nbsp;<input
          type="time"
          v-model="updatedAvailability.endTime"
        />
      </p>
    </div>
    <div id="submitButton">
      <button class="button" type="submit" v-on:click="updateAvailability">Submit</button>
    </div>
  </div>
</template>

<script>
import providerService from "../services/providerService";
export default {
  name: "doctor-availability",
  data() {
    return {
      isAvailabilityVisible: false,
      availabilities: [],
      daysOfWeek: [],
      updatedAvailability: {
        doctorId: 0,
        dayOfWeek: "",
        startTime: "",
        endTime: "",
      },
    };
  },
  methods: {
    updateAvailability(){
      for (let i =0; i < this.daysOfWeek.length; i++){
        if(this.daysOfWeek[i] == 'Monday'){
          this.updatedAvailability.doctorId = this.$route.params.doctorId;
          this.updatedAvailability.dayOfWeek = 'Monday'
          providerService.updateDocAvailability(this.updatedAvailability)
        }else  if(this.daysOfWeek[i] == 'Tuesday'){
          this.updatedAvailability.doctorId = this.$route.params.doctorId;
          this.updatedAvailability.dayOfWeek = 'Tuesday'
          providerService.updateDocAvailability(this.updatedAvailability)
        } else  if(this.daysOfWeek[i] == 'Wednesday'){
          this.updatedAvailability.doctorId = this.$route.params.doctorId;
          this.updatedAvailability.dayOfWeek = 'Wednesday'
          providerService.updateDocAvailability(this.updatedAvailability)
        } else  if(this.daysOfWeek[i] == 'Thursday'){
          this.updatedAvailability.doctorId = this.$route.params.doctorId;
          this.updatedAvailability.dayOfWeek = "Thursday";
          providerService.updateDocAvailability(this.updatedAvailability);
        } else if (this.daysOfWeek[i] == "Friday") {
          this.updatedAvailability.doctorId = this.$route.params.doctorId;
          this.updatedAvailability.dayOfWeek = "Friday";
          providerService.updateDocAvailability(this.updatedAvailability);
        }
      }
      alert("Your availability has been updated");
      this.$router.push({name: 'doctordash', params: {doctorId: this.$route.params.doctorId}})
    }
  },
   created(){
    const currentDoctorId = this.$route.params.doctorId

    providerService
      .getAvailabilityByDoctor(currentDoctorId)
      .then((response) => {
        this.availabilities = response.data;
      });
  },
};
</script>

<style scoped>
#availabilityButton {
  display: flex;
  justify-content: center;
}

#update-availability-form {
  display: flex;
  justify-content: center;
  margin-top: 30px;
  margin-bottom: 30px;
}

h2 {
  margin-top: 30px;
  margin-bottom: 30px;
  text-align: center;
}
.button {
  background-color: #04abcc;
}

.button:hover {
  background-color: #048eaa;
}

#timer {
  display: flex;
  justify-content: center;
  margin-top: 40px;
  margin-bottom: 40px;
}

#submitButton {
  display: flex;
  justify-content: center;
  margin-top: 30px;
  margin-bottom: 30px;
}

</style>