import axios from 'axios';

export default {

  

    getPatientUserIdByUsername(username){
        return axios.get(`/${username}`);
    },

    getPatientByUserId(id){
        return axios.get(`/pid/${id}`);
        
    },
    updatePatientInformation(patient){
        return axios.put(`/pid/update/${patient.patientId}`,patient);
    }

}
    


