<template>
  <div>
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
            <td>{{ office.address }}</td>
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
    <!-- <div class="list">
          
            <div class="officeinfo" v-for="office in offices" v-bind:key="office.officeId">
                <div>
                  <table>
                      <tr><td> {{ office.officeName }}</td></tr>
                      <tr><td>{{ office.address }} </td></tr>
                      <tr><td>{{ office.phoneNumber }} </td></tr>
                  </table>
            </div>
            <div class="officehours" v-for="hour in officeHours" v-bind:key="hour.dayOfWeek">
                  
                      <tr><td>{{hour.dayOfWeek}}:</td><td>{{ hour.startTime}} - </td><td>{{hour.endTime}} </td></tr>
                    
            </div>

            <div class="doctors" v-for="doctor in doctorsInOffice" v-bind:key="doctor.firstName">
                    <tr><td>Dr. {{doctor.firstName}} {{ doctor.lastName}} </td></tr>
            </div>
          </div>
          
      </div> -->

    <div class="updateform">
      <form @submit.prevent="submitForm" v-show="showForm">
        <div class="officeinfo">
          <h2>Office Info</h2>
          <div>
            <label for="officeName">Office Name:</label>
            <input type="text" id="officeName" v-model="officeName" required />
          </div>
          <div>
            <label for="address">Address:</label>
            <input type="text" id="address" v-model="address" required />
          </div>
          <div>
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" v-model="phoneNumber" />
          </div>
        </div>

        <div class="office hours">
          <h2>Office Hours</h2>
          <div>
            <label for="Mondaystart">Monday:</label>
            <input
              type="time"
              id="Mondaystart"
              v-model="officeHours[0].startTime"
              required
            />
          </div>
          <div>
            <label for="Mondayend"></label>
            <input
              type="time"
              id="Mondayend"
              v-model="officeHours[0].endTime"
              required
            />
          </div>
          <div>
            <label for="Tuesdaystart">Tuesday:</label>
            <input
              type="time"
              id="Tuesdaystart"
              v-model="officeHours[1].startTime"
              required
            />
          </div>
          <div>
            <label for="Tuesdayend"></label>
            <input
              type="time"
              id="Tuesdayend"
              v-model="officeHours[1].endTime"
              required
            />
          </div>
          <div>
            <label for="Wednesdaystart">Wednesday:</label>
            <input
              type="time"
              id="Wednesdaystart"
              v-model="officeHours[2].startTime"
              required
            />
          </div>
          <div>
            <label for="Wednesdayend"></label>
            <input
              type="time"
              id="Wednesdayend"
              v-model="officeHours[2].endTime"
              required
            />
          </div>
          <div>
            <label for="Thursdaystart">Thursday:</label>
            <input
              type="time"
              id="Thursdaystart"
              v-model="officeHours[3].startTime"
              required
            />
          </div>
          <div>
            <label for="Thursdayend"></label>
            <input
              type="time"
              id="Thursdayend"
              v-model="officeHours[3].endTime"
              required
            />
          </div>
          <div>
            <label for="Fridaystart">Friday:</label>
            <input
              type="time"
              id="Fridaystart"
              v-model="officeHours[4].startTime"
              required
            />
          </div>
          <div>
            <label for="Fridayend"></label>
            <input
              type="time"
              id="Fridayend"
              v-model="officeHours[4].endTime"
              required
            />
          </div>
        </div>
        <div>
          <button type="submit" >Update</button>
        </div>
      </form>
      <div class="providersAvailable" v-show="showForm">
        <h2>Providers Available</h2>
        <div class="doctors"
            v-for="doctor in doctorsInOffice"
            v-bind:key="doctor.firstName" >
          <p> {{ doctor.firstName }} {{ doctor.lastName }} </p>
          <button> REMOVE </button>
        </div>
        <b-button size="sm" v-b-toggle="'collapse-2'" class="m-1" >Add</b-button>

  <!-- Element to collapse -->
        <b-collapse id="collapse-2">
          <b-card>
            <p>Please select from the list</p>
            <select  v-model="addDoctor">
              
              <option v-for="provider in allProviders" v-bind:key="provider.doctorId" >
                {{ provider.firstName }} {{provider.lastName}} : {{provider.doctorId}}
              </option>
            </select>
            <button> SUBMIT </button>
          </b-card>
        </b-collapse> 
          
      </div>
    </div>
  </div>

  <!-- </div> -->
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
      allProviders:[],
      addDoctor: null,
      doctorChecked: false,
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
          this.allProviders = response.data;
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
      officeService.addDoctorToOffice(this.addDoctor.doctorId,this.activeOffice.officeId);
    },
    removeProvider(){
      officeService.removeDoctorFromOffice()
    }
  },
};
</script>

<style>
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

.updateform{
  display: flex;
  flex-direction: column;
  max-height: 50%;
  background-color: whitesmoke;
  margin-top: 30px;
}

.updateform h2 {
  font-size: 1em;
}
.providersAvailable{
  background-color: seagreen;
}

.providersAvailable button {
  background-color: sandybrown;
}




</style>