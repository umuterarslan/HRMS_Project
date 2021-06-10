import axios from "axios";

export default class EmployerService {
    addEmployer(employer) {
        axios({
            method: "POST",
            url: "http://localhost:8080/api/employers/addemployer",
            data: employer,
            headers: "content-type: application/json",
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
