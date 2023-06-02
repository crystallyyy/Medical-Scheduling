import axios from "axios";

export default {

    getReviewsByOffice(officeId){
        return axios.get(`/reviews/offices/${officeId}`)
    }
}