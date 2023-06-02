<template>
  <div class="reviews">
    <h1>Reviews</h1>

     <div class='actions'>
      <router-link v-bind:to="{ name: 'Offices' }">
        Back to Offices
      </router-link>
      <span style="paddingLeft: 8px; paddingRight: 8px;">|</span>
      <router-link v-bind:to="{ name: 'add-review', params: {officeId: officeId} }">
        Add reivew
      </router-link>
    </div>

    <ReviewListPD />
  </div>
</template>

<script>
import ReviewListPD from '../components/ReviewListPD.vue';

export default {
  components: {
    ReviewListPD
  }
};
</script>
