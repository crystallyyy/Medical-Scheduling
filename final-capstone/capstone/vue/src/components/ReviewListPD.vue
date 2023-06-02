<template>
  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Reviews</th>
        <!-- <th>Number of Reviews</th> -->
        <th>Rating</th>
        <th>Patient</th>
      </tr>
    </thead>
    <tbody>

         <!--  COMMENT   -->
         <!-- need to swap out "product" to something like "office" -->
      <tr v-for="review in reviews" v-bind:key="review.id">
        <td>{{ review.id }}</td>
        <td>
          <!-- <router-link
            v-bind:to="{ name: 'product-detail', params: { id: product.id }}"}></router-link> -->
          {{ review.description }} </td>
       
        <td>{{review.rating}}</td>

        <!-- PATIENT NAME -->
        <td>{{review.patientId}}</td>
        <!-- <td>{{ product.reviews.length }}</td> -->
      </tr>
    </tbody>
  </table>
</template>

<script>
import reviewService from '../services/reviewService.js'
export default {
  name: "review-list-pd",
   data() {
      return {
        reviews : []
      }
    },
  created(){
    const currentOfficeId = this.$route.params.officeId;

    reviewService.getReviewsByOffice(currentOfficeId).then( (response) => 
      this.reviews = response.data)
  }
};
</script>

<style style="scoped">
th,
td {
  text-align: left;
}
td {
  padding-right: 10px;
  vertical-align: top;
}
tr:nth-child(even) {
  background-color: rgb(238, 238, 238);
}
</style>
