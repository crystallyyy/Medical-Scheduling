<template>
  <div class="home">
    <div class="header">
        <div >
          
          <!-- Image and text -->
          <b-navbar variant="faded" type="light" class="nav">
            <b-navbar-brand class="name">
              <img src="https://placekitten.com/g/30/30" class="d-inline-block align-top" alt="LOGO HERE">
              GENESIS COMPLETE CARE
            </b-navbar-brand>
        
          <!-- Use the <router-link> component instead of <b-nav-item> -->
              <router-link to="/login" exact exact-active-class="active" tag="li">
                <b-nav-item class="links">Login or Create Account</b-nav-item>
              </router-link>

          </b-navbar>
        </div>

       <p> still need a lot of edits  -  login botton works, uncomment the router links in app.vue to see hidden nav links</p>
    </div>
    <div class="video">
      <div class="video-container">
        <video src="../../img/DNA molecule.mp4" autoplay loop playsinline muted></video>
        <!-- <div class="callout">
          <h1>Object-Fit </h1>
          <div>The CSS Background-Size: Cover for Inline Images &amp; Videos</div>
        </div> -->
        
      </div>
    </div>
    </div>
    <!-- <h1>Home</h1> -->
    <!-- <div class="fancy-border">
      <h1>WELCOME TO THE MEDICAL SCHEDULING PORTAL</h1>
      
      <img src="image.jpg" alt="Fancy Portal Image">
      <img src="image.jpg" alt="cool image">
      
    </div>

    <div >
      
    </div>
   
    <div>

    </div> -->
</template>

<script>
// import serverService from '../services/ServerService.js';

// export default {
//   name: "home",
//   data() {
//     return {
//       patientList : []
//     }
//   },

//   created() {
//     serverService.getAllPatients().then(
//       // anonymous function
//       (response) => {
//         this.patientList = response.data;
//       }
//     );
//   }
// };
</script>

<style scoped>
.home{
  display: grid;
  height: 100vh;
  grid-template-columns: 1fr;
  grid-template-rows: 30% 70%;
  grid-template-areas: 
  "header"
  "video";
}



.header{
  
  grid-area:header;
  margin: 20px;

}
.video{
  grid-area: video;
  margin: 20px;
}


.video-container {
  position: relative;
  width:100%;
  height: 0;
  
  overflow: hidden;
  @media(min-width: 600px) {
    height: 100%;
  }
  border-radius: 20px;
}
.video-container video {
  object-fit: cover; 
  position: absolute;
  height: 100%;
  width: 100%;
  top: 0;
  left: 0;
  
}
.nav {
  display:flex;
  justify-content: space-between;
  align-content: center;
  padding: 20px;
  margin-top: 20px;
  background-color:teal;
  border: 2px solid #66b2b2;
  border-radius: 20px;
  
}

.links{
  background-color: white;
  padding:10px;
  font: 20px bold; 
  color:black;
  border-radius: 20px;


}
.name{
  color:white;
  font: 40px  bold; 
 
}
p{
  font-size: 40px;
  padding:30px;
}
/* img{
  height: 80%;
} */
</style>