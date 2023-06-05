<template>
  <table>
    <thead>
      <tr>
       
       
        <th>Review</th>
        <!-- <th>Number of Reviews</th> -->
        <th>Rating</th>
    
    
      </tr>
    </thead>
    <tbody>

         <!--  COMMENT   -->
         <!-- need to swap out "product" to something like "office" -->
      <tr v-for="review in reviews" v-bind:key="review.id">
    
        <td>
          <!-- <router-link
            v-bind:to="{ name: 'product-detail', params: { id: product.id }}"}></router-link> -->
          {{ review.description }} </td>
       
        <td>{{review.rating}} / 5</td>

        <!-- PATIENT NAME -->
      
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


table {
  width: 100%;
  border-collapse: collapse;
  font-family: Arial, sans-serif;
}

table thead {
  background-color: #f5f5f5;
}

table th {
  padding: 10px;
  font-weight: bold;
  text-align: left;
  text-transform: uppercase;
}

table tbody tr:nth-child(even) {
  background-color: #f9f9f9;
}

table td {
  padding: 10px;
  font-size: 14px;
  line-height: 1.4;
}

table tbody tr:hover {
  background-color: #e6e6e6;
  transition: background-color 0.3s ease-in-out;
}

.rating {
  display: flex;
  align-items: center;
}

.rating i {
  color: #f2b01e;
  margin-right: 2px;
}

tr:nth-child(even) {
  background-color: #f9f9f9;
}

th,
td {
  padding: 10px;
}

td {
  text-align: left;
}

td {
  vertical-align: top;
}


</style>
