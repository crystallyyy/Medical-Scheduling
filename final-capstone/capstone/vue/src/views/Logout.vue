<template>
  <h1></h1>
</template>

<script>
export default {
  created() {
    this.$store.commit("LOGOUT");
    this.$router.push("/login");
  }
};
</script>


<style>

body {
  background-color: #FFFFFF; /* White background */
  color: #000000; /* Black text */
}

h1, h2, h3, h4, h5, h6 {
  color: #000000; /* Black headings */
}

a {
  color: #00BFFF; /* Sky-blue links */
}

a:hover {
  color: #1E90FF; /* Darker sky-blue on hover */
}

/* Example of a sky-blue button */
.button {
  background-color: #00BFFF;
  color: #FFFFFF;
  border: none;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
}

/* Example of a sky-blue border */
.border {
  border: 2px solid #00BFFF;
}

/* Example of sky-blue background with white text */
.skyblue-background {
  background-color: #00BFFF;
  color: #FFFFFF;
}

/* Example of sky-blue text on white background */
.skyblue-text {
  color: #00BFFF;
  background-color: #FFFFFF;
}

</style>