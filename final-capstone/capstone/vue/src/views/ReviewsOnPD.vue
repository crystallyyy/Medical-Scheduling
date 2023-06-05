<template>
  <div class="reviewsPD">
    <h3>REVIEWS</h3>

    <div class="actions">
      <router-link v-bind:to="{ name: 'patientdash' }">
        Return to Patient Dashboard
      </router-link> | 
      <span style="paddingleft: 8px; paddingright: 8px"></span>
      <router-link
        v-bind:to="{
          name: 'add-review',
          params: { officeId: currentOfficeId },
        }">Add Review
      </router-link>
    </div>

    <ReviewListPD />
  </div>
</template>

<script>
import ReviewListPD from "../components/ReviewListPD.vue";

export default {
  data() {
    return {
      currentOfficeId: this.$route.params.officeId,
    };
  },
  components: {
    ReviewListPD,
  },
};
</script>

<style>
.reviewsPD {
  margin-left: auto;
  margin-right: auto;
  margin-top: 20px;
  margin-bottom: 20px;
  width: 50%; 
  text-align: center;
}

</style>