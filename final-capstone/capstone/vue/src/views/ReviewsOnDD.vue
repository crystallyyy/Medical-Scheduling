<template>
  <div class="reviewsDD">
     <ReviewListDD/>
  </div>
</template>

<script>
import ReviewListDD from '../components/ReviewListDD.vue'
export default {
    components: {
        ReviewListDD
    }
}
</script>

<style>
.reviewsDD {
  margin-left: auto;
  margin-right: auto;
  margin-top: 20px;
  margin-bottom: 20px;
  width: 50%; 
  text-align: center;
}
</style>