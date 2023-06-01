<template>
<div>
    <h1>Find A Provider</h1>
    <p>Find a provider with a compatible availability and click their name to start the booking process.</p>
  <provider-list></provider-list>
  </div>
</template>

<script>
import ProviderList from "../components/ProviderList.vue"
export default {
    components: {
        ProviderList
    }
}
</script>

<style>

</style>