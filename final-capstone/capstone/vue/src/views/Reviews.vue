<template>
  <div class="reviews">
    <h1>Reviews</h1>
    <doctor-review-list />
  </div>
</template>

<script>
import DoctorReviewList from '../components/DoctorReviewList.vue';

export default {
  components: {
    DoctorReviewList
  }
};
</script>
