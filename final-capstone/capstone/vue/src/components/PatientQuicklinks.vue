<template>
    <b-container class="bv-example-row">
        <b-row>
            <b-col>
                <b-card style="max-width: 20rem;" class="dash">
                    <b-card-title>
                        Upcoming Appointments
                    </b-card-title>
                    <b-card-text>
                        Some quick example text to build on the card title and make up the bulk of the card's content.
                    </b-card-text>
                    <b-button href="#" variant="primary">View All</b-button>
                </b-card>

                <b-card style="max-width: 20rem;" class="dash">
                    <b-card-title>
                        Notification Center
                    </b-card-title>
                    <b-card-text>
                        Some quick example text to build on the card title and make up the bulk of the card's content.
                    </b-card-text>
                    <b-button href="#" variant="primary">View All</b-button>
                </b-card>
            </b-col>

            <b-col>
                <b-card style="max-width: 20rem;" class="dash">
                    <b-card-title>
                        Update Info
                    </b-card-title>
                    <b-card-text>
                        Some quick example text to build on the card title and make up the bulk of the card's content.
                    </b-card-text>
                    <b-button href="#" variant="primary">View All</b-button>
                </b-card>

                <b-card style="max-width: 20rem;" class="dash">
                    <b-card-title>
                    More
                    </b-card-title>
                    <b-card-text>
                        Some quick example text to build on the card title and make up the bulk of the card's content.
                    </b-card-text>
                    <b-button href="#" variant="primary">View All</b-button>
                </b-card>
            </b-col>
        

        </b-row>
    </b-container>
</template>



<script>
export default {
    
}
</script>


<style>

.main {
  display: grid;
  grid-template-columns: repeat(2, minmax(0, 1fr));
  gap: 20px;
  justify-items: center;
}

.dash {
  display: flex;
  gap: 20px;
  flex-direction: column;
  text-align: center;
  border: 1px solid #e4e4e4;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  background-color: #fff;
  padding: 20px;
  transition: transform 0.3s ease;
  width: 300px
}

.dash:hover {
  transform: translateY(-5px);
}

.b-card-title {
  font-size: 1.2rem;
  margin-bottom: 10px;
}

.b-card-text {
  margin-bottom: 20px;
}

.b-button {
  display: block;
  width: 100%;
  padding: 12px;
  border: none;
  border-radius: 5px;
  background-color: #04abcc;
  color: #fff;
  font-size: 1rem;
  text-align: center;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.b-button:hover {
  background-color: #04abcc;
}

.b-button:active {
  background-color: #048eaa;
} 

/* a .b-button {

  background-color: #04abcc;
} */

</style>