import axios from 'axios';

export default {

    getAllProviders(){
        return axios.get('/providers');
    }}


