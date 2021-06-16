import axios from "axios";

export default class EmployerService {
    async addEmployer(employer) {
        return await axios({
            method: "POST",
            url: "http://localhost:8080/api/employers/addemployer",
            data: employer,
            headers: { "Content-Type": "application/json;charset=UTF-8" },
        })
            .then((res) => {
                return res.data;
            })
            .catch((err) => {
                return err;
            });
    }

    addPictureToEmployer(id, picture) {
        axios({
            method: "POST",
            url: `http://localhost:8080/api/employers/addemployerpicture?employerId=${id}`,
            data: picture,
            headers: { "Content-Type": "application/json;charset=UTF-8" },
        });
    }

    deleteEmployerById(id) {
        axios.delete(
            `http://localhost:8080/api/employers/deleteemployerbyid?id=${id}`
        );
    }

    getEmployerById(id) {
        return axios.get(
            `http://localhost:8080/api/employers/getemployerbyid?id=${id}`
        );
    }

    getEmployers() {
        return axios.get(`http://localhost:8080/api/employers/getemployers`);
    }
}
