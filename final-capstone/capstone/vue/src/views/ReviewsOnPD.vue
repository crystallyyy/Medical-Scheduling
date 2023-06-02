<template>
  <div class="reviews">
    <h3>REVIEWS</h3>

    <div class="actions">
      <router-link v-bind:to="{ name: 'Offices' }">
        Return to Offices
      </router-link>
      <span style="paddingleft: 8px; paddingright: 8px">|</span>
      <router-link
        v-bind:to="{
          name: 'add-review',
          params: { officeId: currentOfficeId },
        }"
      >
        Add reivew
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
.reviews {
  margin-left: auto;
  margin-right: auto;
  margin-top: 20px;
  margin-bottom: 20px;
  width: 50%; 
  text-align: center;
}

</style>