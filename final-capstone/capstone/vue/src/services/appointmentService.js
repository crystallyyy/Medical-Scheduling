import axios from "axios";

export default{
    addAppointment(appointment){
        axios.post('/appointment', appointment)
    },

    getAppointmentsbyDoctorDate(doctorId, apptDate){
        axios.get(`/appointment/${doctorId}`, apptDate)
    }
}