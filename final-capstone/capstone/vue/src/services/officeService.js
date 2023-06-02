import axios from 'axios';

export default {

    getAllOffices(){
        console.log(axios.get('/offices'));
        return axios.get('/offices');
    },

    getOfficesByDoctorId(doctorId){
        return axios.get(`/offices/doctors/${doctorId}`)
    }
}


