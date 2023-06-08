<template>
  <div class="mainoffice">
    <h3 class="offices">OFFICES</h3>

    <div>
      <table class="officeTable">
        <thead>
          <tr>
            <th>Office Name</th>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="office in offices" v-bind:key="office.officeId">
            <td>{{ office.officeName }}</td>
            <td><a>{{ office.address }}</a></td>
            <td>{{ office.phoneNumber }}</td>

            <td>
              <button @click="showFormWithData(office)">
                <strong>Edit Office Information</strong>
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
   

    <div class="updateform">
      <form @submit.prevent="submitForm" v-show="showForm">
        <div id="officeinfoFrame" class="officeinfo">
          <h2>Office Info</h2>
          <div id="officeNameFrame">
            <label for="officeName">Office Name: &nbsp;&nbsp;</label>
            <input type="text" id="officeName" v-model="officeName" required />
          </div>
          <div id="addressFrame" >
            <label for="address">Address: &nbsp;&nbsp;</label>
            <input type="text" id="address" v-model="address" required />
          </div>
          <div id="phoneNumberFrame" >
            <label for="phoneNumber">Phone Number: &nbsp;&nbsp;</label>
            <input type="text" id="phoneNumber" v-model="phoneNumber" />
          </div>
        </div>
      

        <div class="office hours">
          <h2>Office Hours</h2>
          <div id="mondayFrame">
            <label for="Mondaystart">Monday: &nbsp;&nbsp;</label>
            <input
              type="time"
              id="Mondaystart"
              v-model="officeHours[0].startTime"
              required
            />  &nbsp;&nbsp;
            <label for="Mondayend"></label>
            <input
              type="time"
              id="Mondayend"
              v-model="officeHours[0].endTime"
              required
            />
          </div>

          <div id="tuesdayFrame">
            <label for="Tuesdaystart">Tuesday: &nbsp;&nbsp;</label>
            <input
              type="time"
              id="Tuesdaystart"
              v-model="officeHours[1].startTime"
              required
            /> &nbsp;&nbsp;
            <label for="Tuesdayend"></label>
            <input
              type="time"
              id="Tuesdayend"
              v-model="officeHours[1].endTime"
              required
            />
          </div>
          <div id="wednesdayFrame">
            <label for="Wednesdaystart">Wednesday: &nbsp;&nbsp;</label>
            <input
              type="time"
              id="Wednesdaystart"
              v-model="officeHours[2].startTime"
              required
            /> &nbsp;&nbsp;
            <label for="Wednesdayend"></label>
            <input
              type="time"
              id="Wednesdayend"
              v-model="officeHours[2].endTime"
              required
            />
          </div>
          <div id="thursdayFrame">
            <label for="Thursdaystart">Thursday: &nbsp;&nbsp;</label>
            <input
              type="time"
              id="Thursdaystart"
              v-model="officeHours[3].startTime"
              required
            /> &nbsp;&nbsp;
            <label for="Thursdayend"></label>
            <input
              type="time"
              id="Thursdayend"
              v-model="officeHours[3].endTime"
              required
            />
          </div>
          <div id="fridayFrame">
            <label for="Fridaystart">Friday: &nbsp;&nbsp;</label>
            <input
              type="time"
              id="Fridaystart"
              v-model="officeHours[4].startTime"
              required
            /> &nbsp;&nbsp;
            <label for="Fridayend"></label>
            <input
              type="time"
              id="Fridayend"
              v-model="officeHours[4].endTime"
              required
            />
          </div>
        </div>
        <div id="submitUpdateButtonFrame">
          <button id="submitUpdateButton" type="submit" >Update</button>
        </div>
      </form>

      <!-- <div id="providersAvailableFrame" v-show="showForm">
        <div class="providersAvailable">
          <h2>Providers Available</h2>
          <div class="doctors"
              v-for="doctor in doctorsInOffice"
              v-bind:key="doctor.firstName" >
            <p> {{ doctor.firstName }} {{ doctor.lastName }} </p>
            <button @click="removeProvider(doctor)"> REMOVE </button>
          </div>
        </div>
      </div> -->

        <div id="addDoctorButtonFrame" >
          <b-button id="addDoctorButton" size="sm" v-b-toggle="'collapse-2'" class="m-1" >Add</b-button>
          <div>
    <!-- Element to collapse -->
          <b-collapse id="collapse-2">
            <b-card>
              <p>Please select from the list</p>
              <select  v-model="selectedDoctorId">
                
                <option v-for="option in options" :key="option.doctorId" :value="option.doctorId">
                  {{option.firstName}} {{option.lastName}}
                </option>
              </select>
              <button @click="addProvider()"> SUBMIT </button>
            </b-card>
          </b-collapse> 
        </div> 
      </div>
    </div>
  </div>
</template>

<script>

import officeService from "../services/officeService.js";
import providerService from "../services/providerService.js";

export default {
  name: "edit-office-list",
  data() {
    return {
      offices: [],
      officeHours: [],
      doctorsInOffice: [],
      options:[],
      removedDocId: null,
      selectedDoctorId: null,
      showForm: false,
      officeName: "friday",
      address: "satyrday",
      phoneNumber: "sundat",
      activeOffice: {},
    };
  },

  created() {
    const doctorId = this.$route.params.doctorId;
    officeService.getOfficesByDoctorId(doctorId).then((response) => {
      this.offices = response.data;

      this.offices.forEach((office) => {
        officeService.getOfficeHours(office.officeId).then((response) => {
          this.officeHours = response.data;
        });

        officeService.getDoctors(office.officeId).then((response) => {
          this.doctorsInOffice = response.data;
        });

        providerService.getAllProviders().then((response)=> {
          this.options = response.data;
        })
      });
    });
  },
  methods: {
    submitForm() {
      this.activeOffice.officeName = this.officeName;
      this.activeOffice.address = this.address;
      this.activeOffice.phoneNumber = this.phoneNumber;

      officeService.updateOffice(this.activeOffice);
      this.updateHours();
      this.showForm = false;
    },
    showFormWithData(office) {
      this.showForm = true;
      this.activeOffice = office;
      this.officeId = office.officeId;
      this.officeName = office.officeName;
      this.address = office.address;
      this.phoneNumber = office.phoneNumber;

      officeService.getOfficeHours(this.officeId).then((response) => {
        this.officeHours = response.data;
      });

      officeService.getDoctors(this.officeId).then((response) => {
        this.doctorsInOffice = response.data;
      });
    },

    updateHours(){
      this.officeHours.forEach((officehour)=> {
        officeService.updateOfficeHours(officehour);
      });
    },

    addProvider(){
      
      officeService.addDoctorToOffice(this.selectedDoctorId,this.activeOffice.officeId);
    },
    removeProvider(provider){

      officeService.removeDoctorFromOffice(provider.doctorId,this.activeOffice.officeId);
    }
  },
};
</script>

<style scoped>

/* #officeinfoFrame {
  display: flex;
  justify-content: center;

} */

h2 {
  text-align: center;
}

.mainoffice{
  display: flex;
  flex-direction: column;
  background-color: blueviolet;
  justify-content: center;
}
.actions {
  margin-left: auto;
  margin-right: auto;
  margin-top: 20px;
  margin-bottom: 20px;
  width: 50%;
  text-align: center;
}

h3 {
  margin-left: auto;
  margin-right: auto;
  margin-top: 20px;
  margin-bottom: 20px;
  width: 50%;
  text-align: center;
}

.officeTable {
  margin-left: auto;
  margin-right: auto;
  width: 80%;
  text-align: center;
}

.officeTable th,
.officeTable td {
  padding: 10px;
}

.officeTable th {
  background-color: #f2f2f2;
}

.officeTable tbody tr:nth-child(even) {
  background-color: #f9f9f9;
}

.officeTable tbody tr:hover {
  background-color: #e6e6e6;
}

button {
  background-color: #e6e6e6;
  color: white;
  border: none;
  padding: 5px 10px;
  cursor: pointer;
}

button:hover {
  background-color: #e6e6e6;
}

.list {
  padding: 20px;
}

.officeinfo,
.officehours,
.doctors {
  padding-top: 15px;
  padding-bottom: 15px;
}

.officeinfo div {
  padding: 20px;
}

.updateform{
  display: flex;
  /* justify-content: center; */
  flex-direction: column;
  width: 100%;

  max-height: 50%;
  background-color: whitesmoke;
  margin-top: 30px;
}

.updateform h2 {
  background-color: darkolivegreen;
  font-size: 1em;
}

.officehours {
  background-color: crimson;
  display: flex;
}

/* #providersAvailable{
  display: flex;
  justify-content: center;
} */

#providersAvailableFrame{
  display: flex;
  justify-content: center;
  background-color: seagreen;
}

.providersAvailable button {
  background-color: rgb(233, 24, 24);
}

.doctors {
  display: flex;
  flex-basis: 50%;
  align-content: center;
  background-color: burlywood;
  
}
.doctors p {
  background-color: cadetblue;
  font-size: 20px;
}
.doctors button {
  margin-left: 10px;
  padding:5px;
}

#officeNameFrame {
  margin-left: 240px;
}

#addressFrame {
  margin-left: 272px;
}

#phoneNumberFrame {
  margin-left: 221px;
}

#mondayFrame {
  margin-left: 288px;
  margin-bottom: 8px;
}

#tuesdayFrame {
  margin-left: 288px;
  margin-bottom: 8px;
}

#wednesdayFrame {
  margin-left: 265px;
  margin-bottom: 8px;
}

#thursdayFrame {
  margin-left: 282px;
  margin-bottom: 8px;
}

#fridayFrame {
  margin-left: 304px;
  margin-bottom: 8px;
}

#addDoctorButton {
  background-color: #04abcc;
  margin-top: 20px;
  margin-bottom: 20px;
}

#addDoctorButton:hover {
  background-color: #048eaa;
}

#addDoctorButtonFrame {
  display: flex;
  justify-content: center;
  
}

p {
  text-align: center;
}

#submitUpdateButton {
  background-color: #04abcc;
  margin-top: 20px;
  margin-bottom: 20px;
}

#submitUpdateButton:hover {
  background-color: #048eaa;
}

#submitUpdateButtonFrame {
  display: flex;
  margin-left: 445px;
}
</style>