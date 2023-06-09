<template>
  <div>
    <h2 id="h2">Current Patient Information</h2>
    <div id="patient-info-display">
      <p>Name:</p>
      <p>{{ patient.firstName }} {{ patient.lastName }}</p>
      <p>Date of Birth:</p>
      <p>{{ patient.dateOfBirth }}</p>
      <p>Address:</p>
      <p>{{ patient.address }}</p>
      <p>Phone Number:</p>
      <p>{{ patient.phoneNumber }}</p>
    </div>

    <div class="accordion" role="tablist">
      <b-card no-body class="mb-1">
        <b-card-header
          id="buttonHeader"
          header-tag="header"
          class="p-1"
          role="tab"
        >
          <b-button
            id="updateInformationButtonFrame"
            block
            v-b-toggle.accordion-1
            variant="info"
            >Update Information (Click to Open)</b-button
          >
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
                <input
                  type="text"
                  id="state"
                  v-model="address.state"
                  required
                />
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
    </div>
  </div>
</template>

<script>
import patientService from "../services/patientService.js";
export default {
  name: "update-info-pd",

  data() {
    return {
      patient: {
        firstName: "",
        lastName: "",
        dateOfBirth: "",
        address: "",
        phoneNumber: "",
      },

      updatedPatient: {
        patientId: 0,
        firstName: "",
        lastName: "",
        dateOfBirth: "",
        address: "",
        phoneNumber: "",
      },
      address: {
        address_line1: "",
        address_line2: "",
        city: "",
        state: "",
        zip_code: "",
      },
    };
  },

  created() {
    const patientId = this.$route.params.patientId;
    patientService.getPatientByPatientId(patientId).then((response) => {
      this.patient.firstName = response.data.firstName;
      this.patient.lastName = response.data.lastName;
      this.patient.dateOfBirth = response.data.dateOfBirth;
      this.patient.address = response.data.address;
      this.patient.phoneNumber = response.data.phoneNumber;
    });
  },
  methods: {
    submitForm() {
      this.updatedPatient.address = `${this.address.address_line1}, ${this.address.address_line2}, ${this.address.city}, ${this.address.state} ${this.address.zip_code}`;
      this.updatedPatient.patientId = this.$store.state.role.roleId;

      patientService
        .updatePatientInformation(this.updatedPatient)
        .then((response) => {
          if (response.status == 200) {
            this.updatedPatient = {};
            alert("Patient Information updated");
            this.$router.push({ name: "patientdash" });
          }
        });
    },
  },
};
</script>

<style scoped>
#h2 {
  text-align: center;
  margin-top: 30px;
  margin-bottom: 30px;
}

#patient-info-display {
  margin-left: 200px;
  margin-bottom: 60px;
}

#updateInformationButton {
  background-color: #04abcc;
  margin-top: 30px;
  margin-bottom: 30px;
}

#updateInformationButton:hover {
  background-color: #048eaa;
}

#updateInformationButtonFrame {
  display: flex;
  justify-content: center;
}

#firstNameFrame {
  display: flex;
  margin-top: 30px;
  margin-left: 225px;
  margin-bottom: 13px;
}

#lastNameFrame {
  display: flex;
  margin-left: 227px;
  margin-bottom: 13px;
}

#dateOfBirthFrame {
  display: flex;
  margin-left: 213px;
  margin-bottom: 13px;
}

#address1Frame {
  display: flex;
  margin-left: 200px;
  margin-bottom: 13px;
}

#address2Frame {
  display: flex;
  margin-left: 200px;
  margin-bottom: 13px;
}

#cityFrame {
  display: flex;
  margin-left: 276px;
  margin-bottom: 13px;
}

#stateFrame {
  display: flex;
  margin-left: 268px;
  margin-bottom: 13px;
}

#zipCodeFrame {
  display: flex;
  margin-left: 240px;
  margin-bottom: 13px;
}

#phoneNumberFrame {
  display: flex;
  margin-left: 196px;
  margin-bottom: 13px;
}

#submitButtonFrame {
  display: flex;
  margin-left: 380px;
  margin-bottom: 13px;
}

#submitButton {
  background-color: #04abcc;
  margin-top: 30px;
  margin-bottom: 30px;
}

#submitButton:hover {
  background-color: #048eaa;
}

.mb-1 {
  display: flex;
  justify-content: center;
  width: 50%;
}

.accordion {
  display: flex;
  justify-content: center;
}
</style>