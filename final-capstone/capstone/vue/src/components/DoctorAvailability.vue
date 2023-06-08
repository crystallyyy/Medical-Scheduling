<template>
  <div>
    <h2>Current Availability</h2>
    <div id="currentAvailability">
      <!-- <li
        v-for="availability in availabilities"
        v-bind:key="availability.dayOfWeek"
      > -->
        <p  v-for="availability in availabilities"
        v-bind:key="availability.dayOfWeek">
          {{ availability.dayOfWeek }}: {{ availability.startTime }}-{{
            availability.endTime
          }}
        </p>
      <!-- </li> -->
    </div>

    <!-- <div id="availabilityButton">
      <button class="button">Update Availability</button>
    </div> -->



    <div class="availabilityButton" role="tablist">
      <b-card no-body class="mb-1">
        <b-card-header id="buttonHeader" header-tag="header" class="p-1" role="tab">
        <b-button id="updateInformationButtonFrame" block v-b-toggle.accordion-1 variant="info">Update Availability (Click to Open)</b-button>
      </b-card-header>
      <b-collapse id="accordion-1" accordion="my-accordion" role="tabpanel">
        <b-card-body>
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
        </b-card-body>
      </b-collapse>
    </b-card>
    </div>







<!-- <div class="accordion" role="tablist">
      <b-card no-body class="mb-1">
        <b-card-header id="buttonHeader" header-tag="header" class="p-1" role="tab">
        <b-button id="updateInformationButtonFrame" block v-b-toggle.accordion-1 variant="info">Update Information (Click to Open)</b-button>
      </b-card-header>
      <b-collapse id="accordion-1" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <div id="patient-info-update-form">
          <div id="firstNameFrame">
            <label for="firstName">First Name: &nbsp;&nbsp;</label>
            <input
              type="text"
              name="firstName"
              id="firstName"
              v-model="updatedPatient.firstName"
              required
            />
          </div>
          <div id="lastNameFrame">
            <label for="lastName">Last Name: &nbsp;&nbsp;</label>
            <input
              type="text"
              name="lastName"
              id="lastName"
              v-model="updatedPatient.lastName"
              required
            />
          </div>
          <div id="dateOfBirthFrame">
            <label for="dateOfBirth">Date of Birth: &nbsp;&nbsp;</label>
            <input
              type="date"
              name="dateOfBirth"
              id="dateOfBirth"
              v-model="updatedPatient.dateOfBirth"
              required
            />
          </div>
          <div id="address1Frame">
            <label for="address_line1">Address Line 1: &nbsp;&nbsp;</label>
            <input
              type="text"
              id="address_line1"
              v-model="address.address_line1"
              required
            />
          </div>
          <div id="address2Frame">
            <label for="address_line2">Address Line 2: &nbsp;&nbsp;</label>
            <input
              type="text"
              id="address_line2"
              v-model="address.address_line2"
            />
          </div>
          <div id="cityFrame">
            <label for="city">City: &nbsp;&nbsp;</label>
            <input type="text" id="city" v-model="address.city" required />
          </div>
          <div id="stateFrame">
            <label for="state">State: &nbsp;&nbsp;</label>
            <input type="text" id="state" v-model="address.state" required />
          </div>
          <div id="zipCodeFrame">
            <label for="zip_code">Zip Code: &nbsp;&nbsp;</label>
            <input
              type="text"
              id="zip_code"
              v-model="address.zip_code"
              required
            />
          </div>
          <div id="phoneNumberFrame">
            <label for="phoneNumber">Phone Number: &nbsp;&nbsp;</label>
            <input
              type="text"
              name="phoneNumber"
              id="phoneNumber"
              v-model="updatedPatient.phoneNumber"
            />
          </div>
          <div id="submitButtonFrame">
            <button id="submitButton" type="submit" v-on:click="submitForm">
              Submit
            </button>
          </div>
        </div>
        </b-card-body>
      </b-collapse>
    </b-card>
    </div> -->






    <!-- <div id="update-availability-form">
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
    </div> -->
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
  width: 50%
}

.mb-1{
  display: flex;
  justify-content: center;
  width: 100%
}

.accordion {
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

#currentAvailability {
  text-align: center;
  margin-top: 30px;
  margin-bottom: 30px
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