<template>
  <div class="reviews">
    <h1>Reviews</h1>

    <div class="actions">
      <router-link v-bind:to="{ name: 'Offices' }">
        Back to Offices
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
