import axios from "axios";

export default class TechnologieService {
    async addTechnologie(technologie) {
        return await axios({
            method: "POST",
            url: "http://localhost:8080/api/technologies/addtechnologie",
            data: technologie,
            headers: { "Content-Type": "application/json;charset=UTF-8" },
        })
            .then((res) => {
                return res.data.message;
            })
            .catch((err) => {
                return err;
            });
    }

    async getTechnologies() {
        return await axios.get(
            "http://localhost:8080/api/technologies/gettechnologies"
        );
    }

    async deleteTechnology(id) {
        return await axios.delete(
            `http://localhost:8080/api/technologies/deletetechnology?id=${id}`
        );
    }
}
