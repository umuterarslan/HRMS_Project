import axios from "axios";

export default class JobPositionService {
    addJobPosition(jobPosition) {
        axios({
            method: "POST",
            url: "http://localhost:8080/api/jobpositions/getpositions",
            data: jobPosition,
            headers: "content-type: application/json",
        });
    }

    getJobPositions() {
        return axios.get("http://localhost:8080/api/jobpositions/getpositions");
    }
}
