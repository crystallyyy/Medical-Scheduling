<template>
    <div class="container mt-5">
<div class="row">
        <div>
            <h3 class="mb-3 text-center">Select a Day</h3>
        <date-picker v-model="date" :config="options"  @click="passDate"></date-picker>
        <h2>{{date.getDay()}}</h2>
        <h2>{{date}}</h2>
        </div>
  </div>
  </div>
</template>

<script>
import datePicker from 'vue-bootstrap-datetimepicker';
import 'bootstrap/dist/css/bootstrap.css';
import 'pc-bootstrap4-datetimepicker/build/css/bootstrap-datetimepicker.css'

export default {
     
components: {
    datePicker
},
data(){
    return{
   date: new Date(),
   day: '',
   options: {
       format: 'MM/DD/YY',
       useCurrent: false,
   },
   
};

},

methods: {
    passDate(){
        
        const day = this.date.getDay();
        this.$emit('passDate', this.date, day)
    },

}

}
</script>