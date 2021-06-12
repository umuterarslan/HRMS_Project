import axios from "axios";

export default class TechnologieService {
    addTechnologie(technologie) {
        axios({
            method: "POST",
            url: "http://localhost:8080/api/technologies/addtechnologie",
            data: technologie,
            headers: "content-type: application/json",
        });
    }

    getTechnologies() {
        return axios.get(
            "http://localhost:8080/api/technologies/gettechnologies"
        );
    }
}
