<template>
  <div>
    <h3>Add Review</h3>

    <div class='actions'>
      <router-link v-bind:to="{ name: 'reviewsPD' }">
        Return to Reviews
      </router-link>
      <span style="paddingLeft: 8px; paddingRight: 8px;"></span>
    </div>

    <add-review />
  </div>
</template>

<script>
import AddReview from "../components/AddReview.vue";

export default {
  components: {
    AddReview
  }
};
</script>

<style>

</style>
