import axios from "axios";

export default {

    createIssue(issue) {

      return axios.post('/createissue', issue);
    
    },

}