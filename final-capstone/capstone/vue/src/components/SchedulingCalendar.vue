<template>
  <div>
         <b-calendar
          locale="en-US"
        ></b-calendar>
        <date-picker v-model="date"></date-picker>
  </div>
</template>

<script>
import datePicker from 'vue-bootstrap-datetimepicker';
import 'bootstrap/dist/css/bootstrap.css';
import 'pc-bootstrap4-datetimepicker/build/css/bootstrap-datetimepicker.css'
export default {
name: 'scheduling-calendar',
components: {
    datePicker
},
data(){
    return{
   date: ''     
    }
}

}
</script>

<style>

</style>