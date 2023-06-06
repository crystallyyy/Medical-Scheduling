<template>
  <div>
    <h3>FIND A PROVIDER</h3>
    <div class="actions">
      <router-link v-bind:to="{ name: 'patientDash' }">
        Return to Dashboard
      </router-link>
    </div>
    <!-- <p>Find a provider with a compatible availability and click their name to start the booking process.</p> -->

    <!-- <div class="button">
      <b-button v-b-toggle.collapse-1 variant="primary"
        >Toggle Collapse</b-button
      >
      <b-collapse id="collapse-1" class="mt-2">
        <b-card>
          <p class="card-text">Collapse contents Here</p>
          <b-button v-b-toggle.collapse-1-inner size="sm"
            >Toggle Inner Collapse</b-button
          >
          <b-collapse id="collapse-1-inner" class="mt-2">
            <b-card>Hello!</b-card>
          </b-collapse>
        </b-card>
      </b-collapse>
    </div> -->

    <table class="providerTable">
      <thead>
        <tr>
          <th>Provider Name</th>
          <th>Address</th>

          <th>Hours</th>

          <th>Phone Number</th>
          <th>Actions</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="office in offices" v-bind:key="office.officeId">
          <td>{{ provider.providerName }}</td>
          <td>{{ provider.address }}</td>
          <td>{{ provider.hours }}</td>
          <td>{{ provider.phoneNumber }}</td>
          <td>
            <button>
              <router-link
                :to="{
                  name: 'reviewsPD',
                  params: { officeId: office.officeId },
                }"
              >
                <strong>Read Reviews</strong>
              </router-link>
            </button>
          </td>
        </tr>
      </tbody>
    </table>

    <div class="list">
      <div
        class="providerinfo"
        v-for="provider in providers"
        v-bind:key="provider.providerId"
      >
        <div>
          <table>
            <tr>
              <td>{{ provider.providerName }}</td>
            </tr>
            <tr>
              <td>{{ provider.address }}</td>
            </tr>

            <!-- NEW -->
            <tr>
              <td>{{ provider.hours }}</td>
            </tr>

            <tr>
              <td>{{ provider.phoneNumber }}</td>
            </tr>
          </table>
        </div>
        <div
          class="officehours"
          v-for="hour in officeHours"
          v-bind:key="hour.dayOfWeek"
        >
          <tr>
            <td>{{ hour.dayOfWeek }}:</td>
            <td>{{ hour.startTime }} -</td>
            <td>{{ hour.endTime }}</td>
          </tr>
        </div>

        <div
          class="doctors"
          v-for="doctor in doctorsInOffice"
          v-bind:key="doctor.firstName"
        >
          <tr>
            <td>Dr. {{ doctor.firstName }} {{ doctor.lastName }}</td>
          </tr>
        </div>
      </div>
    </div>

    <provider-list></provider-list>
  </div>
</template>

<script>
import ProviderList from "../components/ProviderList.vue";
export default {
  components: {
    ProviderList,
  },
};
</script>

<style scoped>
.button {
  display: inline-block;
  justify-self: center;
}
.mt-2 {
  padding: 0;
  list-style: none;
}

.card-text {
  padding: 10px;
  text-align: center;
}
</style>