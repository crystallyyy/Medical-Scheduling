import axios from 'axios';

export default {

    getAllProviders(){
        return axios.get('/providers');
    },

    getDoctorUserIdByUsername(username){
        return axios.get(`/${username}`);
    },

    getDoctorByUserId(id){
        return axios.get(`/pid/${id}`);
        
    },
    updateDoctorInformation(doctor){
        return axios.put(`/pid/update/${doctor.doctorId}`,doctor);
    },

    getAvailabilityByDoctor(doctorId){
        return axios.get(`/availability/${doctorId}`)
    },

    updateDocAvailability(availability){
        return axios.put(`/availability/${availability.doctorId}`, availability)
    },

    getAllAvailabilities(){
        return axios.get(`/availabilities`)
    },

    createAvailability(availability){
        return axios.post(`/availability`, availability)
    },

    getDoctorByDoctorId(doctorId){
        return axios.get(`/providers/${doctorId}`)
    }

}
    


