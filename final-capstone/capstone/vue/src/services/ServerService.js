import axios from 'axios';

export default {

    getAllPatients() {

        return axios.get("/allPatients");

    },

    addPatient(patient) {
        return axios.post('/addPatient', patient);
    },

    // adoptPuppy(id) {

    //     // use back-kick (`) when you are using a variable
    //     return axios.delete(`/puppy/${id}`);
    // }
}