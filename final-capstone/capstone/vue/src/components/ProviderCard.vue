<template>
  <div>
     <h2>Dr. {{ doctor.firstName }} {{ doctor.lastName }}</h2>
      <h3>{{ doctor.email }}</h3>
  </div>
</template>

<script>
export default {
props:{
    doctor: Object,
}
}
</script>

<style>

</style>