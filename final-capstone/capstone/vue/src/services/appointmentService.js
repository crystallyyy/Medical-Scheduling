import axios from "axios";

export default{
    addAppointment(appointment){
      return  axios.post('/appointment', appointment)
    },

    getAppointmentsbyDoctorDate(doctorId, apptDate){
      return  axios.get(`/appointment/${doctorId}`, apptDate)
    },

    getAppointmentsByPatient(patientId){
      return  axios.get(`/appointments/${patientId}`)
    }
}