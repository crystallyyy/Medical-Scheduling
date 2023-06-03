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
                    Not Sure
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

.main{
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    background-color: sandybrown;
}
b-card {
    display: flex;
    flex-direction: column;
    flex-basis: 50%;
    height: 200px;
    border: 4px black solid;
    background-color: white;
}
b-button {
    padding: 5px;
    margin: auto;
    background-color: teal;
    border-radius: 8px;
    

}
b-card b-card-title {
    font-size: 25px;
    font-weight: bold;
    padding: 5px;
    
}

</style>