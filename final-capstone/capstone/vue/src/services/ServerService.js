import axios from 'axios';

export default {

    getAllPatients() {

        return axios.get('/allPatients');

    },

    addPatient(patient) {
        return axios.post('/addPatient', patient);
    },

   
}