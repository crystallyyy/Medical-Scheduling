import axios from 'axios';

export default {

    getAllOffices(){
        console.log(axios.get('/offices'));
        return axios.get('/offices');
    },

    getOfficesByDoctorId(doctorId){
        return axios.get(`/offices/doctors/${doctorId}`)
    },

    getOfficeIdsByDoctor(doctorId){
        return axios.get(`/offices/${doctorId}`)
    },
    
    updateOfficeById(officeId, data){
        return axios.put(`/offices/${officeId}`, data)
    },
    updateOffice(office){
        return axios.put(`/updateoffice`, office);
    },

    getOfficeHours(officeId){
        console.log(axios.get(`/offices/office-hours/${officeId}`))
        return axios.get(`/offices/office-hours/${officeId}`)
    },

    getDoctors(officeId){
        console.log(axios.get(`/providers/offices/${officeId}`))
        return axios.get(`/providers/offices/${officeId}`)
    }
}


