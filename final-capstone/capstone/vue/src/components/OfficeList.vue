<template>
  <div>
    <ul>
      <li v-for="office in offices" v-bind:key="office.officeId">
        <h2>Dr. {{ office.name }} </h2>
        <h3>{{ office.address }}</h3>
        <h3> {{office.phoneNumber}}</h3>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
    name: 'office-list'

}
</script>

<style>

</style>