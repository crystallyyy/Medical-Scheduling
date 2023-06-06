<template>
  <h1></h1>
</template>

<script>
export default {
  created() {
    this.$store.commit("LOGOUT");
    this.$router.push("/login");
    console.log("logout" + this.$store.state.role.role);
  }
};
</script>


<style scope>
body {
  background-color: #ffffff;
  color: #000000;
}

h1,
h2,
h3,
h4,
h5,
h6 {
  color: #000000;
}

a {
  color: #04abcc;
}

a:hover {
  color: #048eaa;
}

.button {
  background-color: #04abcc;
  color: #ffffff;
  border: none;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
}
</style>