<template>
  <form v-on:submit.prevent="addNewReview">
    <div class="form-element">
     <div class="form-element">
      <label for="review">Patient Review</label>
      <textarea id="review" v-model="newReview.description"></textarea>
    </div>
    </div>
    <div class="form-element">
      <label for="rating">Rating:</label>
      <select id="rating" v-model.number="newReview.rating">
        <option value="1">1 Star</option>
        <option value="2">2 Stars</option>
        <option value="3">3 Stars</option>
        <option value="4">4 Stars</option>
        <option value="5">5 Stars</option>
      </select>
    </div>
   
    <div class="actions">
      <button v-on:click="resetForm" type="button" >Reset Form</button>
      <button  v-on:click="this.$router.push({path: '/patientDash', params: {patientId: this.$store.state.role.roleId}})">Cancel</button>
      <button>Submit</button>
    </div>
  </form>
</template>

<script>
import reviewService from '../services/reviewService';
export default {
  name: "add-review",
  data() {
    return {
      newReview: {
        officeId: 0,
        description: "",
        rating: 0
      }
    };
  },
  methods: {
    addNewReview() {
      //TODO: add check so that they cannot submit empty review
      const officeID = this.$route.params.officeId;
      this.newReview.officeId = officeID;
      reviewService.addReview(this.newReview).then( (response) => {
        if(response.status === 201){
          this.$router.push({ path: "/patientDash" });
        }
      })
    },
    resetForm() {
      this.newReview = {};
    }
  }
};
</script>

<style scoped>
form {
  width: 500px;
  margin: 20px;
  margin-left: auto;
  margin-right: auto;
  margin-top: auto;
  margin-bottom: auto;
  width:50%; 
  text-align: center;

}
.form-element label {
  width: 400px;
  vertical-align: top;
  margin-left: auto;
  margin-right: auto;
}

.form-element input,
select,
textarea {
  width: 600px;
  font-size: 1.1rem;
  margin-left: auto;
  margin-right: auto;
}

.form-element textarea {
  height: 150px;
  
}

.actions {
  float: auto;
  
  margin-left: auto;
  margin-right: auto;
  /* margin-top: auto; */
  margin-bottom: auto;
  width:100%; 
  text-align: center;

}
.actions button {
  margin-left: 10px;
  
  background-color: #04abcc;
  color: white;
  border: none;
  padding: 5px 10px;
  cursor: pointer;

}

.actions button:hover {
  background-color: #048eaa;
}

</style>
