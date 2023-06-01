<template>
    <div class="main">
        <aside class="sidenav">
            <div class="imgdiv">
                <!-- <img src="../img/logo.jpg" alt="company logo"> -->
            </div>    
            <nav>
                <ul>
                  <li class="active" :class="{active: isActive}" @click="setActive">DASHBOARD</li>
                  <li class="" :class="{active: isActive}" @click="setActive"> <router-link :to="{name: 'schedule-appointment'}">SCHEDULE AN APPOINTMENT</router-link> </li>
                  <li class="" :class="{active: isActive}" @click="setActive">UPDATE INFO</li>
                  <li class="" :class="{active: isActive}" @click="setActive">VISIT HISTORY</li>
                  <b-button variant="primary">Click me!</b-button>
                </ul>
            </nav>      
            <button id="support">CONTACT SUPPORT</button>
        </aside>
        <div class="content">
        
            <div class="dashboard"></div>
            <div class="profile"></div>
            <div class="offices"></div>
            <div class="contact"></div>
        </div>
    </div>
</template>

<script>

export default {
  name: "PatientDashboard",
  data() {
    return {

    isActive: false,
    methods:{
          setActive(){
        //set isActive to false for all other li elements
        //set isActive to true for clicked li element
    
         this.isActive = true;
        }
     } 
    }
  }
}
</script>

<style>
.main{
    display: grid;
    grid-template-columns: 25% 75%;
    grid-template-areas: "sidenav" "content";
    

}
.sidenav {
    grid-area: sidenav;
    background-color: grey;
    height: 100vh;
    display:flex;
    flex-direction: column;
    align-content: center;
    
    
    
}
.content{
    grid-area: content;
    background-color: white;
}


.imgdiv {
    flex-basis: 25%;
    display: flex;
    justify-content: center;
    align-items: center;
    
    
}
nav {
    flex-basis: 60%;
    display: flex;
    background-color: grey;
    align-content: center;
    justify-content: center;
}
nav ul{
    flex-grow: 1;
   list-style-type: none;
   margin: 0;
   padding:0;
   justify-content: center;
   
 
}
nav ul li{
    padding: 40px 0px;
    background-color: turquoise;
    border-block: 1px solid black;
    text-align: center;
}

.active {
    background-color: white;
}
#support {
    flex-basis: 15%;
    border: 0px;
    
}
img{
    height: 50%;
    border-radius: 50%;
    
}
</style>