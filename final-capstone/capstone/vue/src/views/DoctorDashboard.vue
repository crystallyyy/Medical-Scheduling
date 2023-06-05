<template>
  <div id="main">
    <div id="nav">
      <div class="imgdiv">
        <img id="img" src="../../img/logo2.jpeg" alt="company logo" />
      </div>
      <ul class="nav flex-column">
        <li class="nav-item">
          <button type="button" class="btn btn-info" @click="activeCard = 1">
            Dashboard
          </button>
        </li>
        <li class="nav-item">
          <button type="button" class="btn btn-info" @click="activeCard = 2">
            My Profile
          </button>
        </li>
        <li class="nav-item">
          <button type="button" class="btn btn-info" @click="activeCard = 3">
            Manage Locations
          </button>
        </li>
        <li class="nav-item">
          <button type="button" class="btn btn-info" @click="activeCard = 4">
            Manage Availability
          </button>
        </li>
      </ul>
    </div>

    <div id="content">
      <div class="card card-body" v-show="activeCard === 1">
        Content for show dashboard
      </div>
      <div class="card card-body" v-show="activeCard === 2">
        Content for my profile
      </div>
      <div class="card card-body" v-show="activeCard === 3">
        Content for manage location
      </div>
      <div class="card card-body" v-show="activeCard === 4">
        Content for change availability
      </div>
    </div>
    <div class="card card-body" v-show="activeCard === 4">
      Content for change availability
      <doctor-availability></doctor-availability>
    </div>
  </div>

  <!-- include contact support -->
</template>

<script>
import DoctorAvailability from "../components/DoctorAvailability.vue";
export default {
  components: { DoctorAvailability },
  data() {
    return {
      activeCard: null,
      methods: {},
    };
  },
};
</script>

<style scoped>
#main {
  display: flex;
}

#nav {
  width: 200px;
  background-color: #f1f1f1;
}

.imgdiv {
  padding: 10px;
}

#img {
  width: 100%;
}

.nav {
  padding: 0;
  list-style: none;
}

.nav-item {
  padding: 10px;
  text-align: center;
}

.btn {
  width: 100%;
}

#content {
  flex: 1;
  padding: 20px;
}

.card {
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.card-body {
  padding: 10px;
  background-color: #fff;
  display: none;
}

.card-body.show {
  display: block;
}
</style>
