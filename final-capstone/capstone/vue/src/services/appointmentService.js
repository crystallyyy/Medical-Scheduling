import axios from "axios";

export default{
    addAppointment(appointment){
        axios.post('/appointment', appointment)
    }
}