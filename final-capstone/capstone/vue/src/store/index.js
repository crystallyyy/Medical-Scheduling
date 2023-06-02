import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'


Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    reviews: [
          {
            id: 1001,
            reviewer: 'Jane Kim',
            title: 'Great Experience!',
            review:
              "I had the pleasure of visiting Dr. Jung recently, and I must say, they are an outstanding doctor. Their expertise and knowledge are evident, and they took the time to listen to my concerns. Dr. Jung was thorough in their examination and explained the diagnosis and treatment plan in a way that was easy to understand. I highly recommend Dr. Jung to anyone seeking top-notch medical care.",
            rating: 5,
            favorited: false
          },
          {
            id: 1002,
            reviewer: 'Mark Johnson',
            title: 'Impersonal Experience.',
            review:
              "My visit with Dr. Jung left me feeling disappointed. While they seemed knowledgeable, the overall experience was impersonal. Dr. Jung barely made eye contact and seemed rushed during the appointment. I didn't feel like my concerns were adequately addressed. The staff was friendly, but the lack of connection with the doctor made me question the quality of care.",
            rating: 2,
            favorited: false
          },
          {
            id: 1003,
            reviewer: 'Lily Smith',
            title: 'Exceptional care.',
            review:
              "Dr. Jung has an exceptional bedside manner. They are kind, compassionate, and truly dedicated to their patients' well-being. During my visit, Dr. Jung listened attentively to my concerns and provided me with detailed explanations and treatment options. Their warm and caring demeanor instantly put me at ease. I highly recommend Dr. Jung for their excellent patient care.",
            rating: 5,
            favorited: false
          },
          {
            id: 1004,
            reviewer: 'Michael Carter',
            title: 'Lackluster Experience',
            review:
              "My visit with Dr. Jung was a lackluster experience. The waiting time was excessively long, and the receptionist seemed disorganized. When I finally saw Dr. Jung, they appeared disinterested and didn't take the time to thoroughly address my concerns. The overall atmosphere in the clinic was chaotic, and I left feeling dissatisfied with the level of care provided.",
            rating: 3,
            favorited: false
          }
        ],
      
      // {
      //   id: 2,
      //   name: "Dr. Buck",
      //   description: "General surgery",
      //   reviews: []
      // },
      // {
      //   id: 3,
      //   name: "Dr. Almaraz",
      //   description: "Pediatrics",
      //   reviews: []
      // },
      // {
      //   id: 4,
      //   name: "Dr, Aninweze",
      //   description: "Neurology",
      //   reviews: []
      // },
    
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    
  }
})
