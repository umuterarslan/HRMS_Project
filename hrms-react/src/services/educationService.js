import axios from "axios";

export default class EducationService {
    addEducation(education) {
        axios({
            method: "POST",
            url: "http://localhost:8080/api/educations/addeducation",
            data: education,
            headers: "content-type: application/json",
        });
    }

    getEducationSortedById(id) {
        return axios.get(
            `http://localhost:8080/api/educations/geteducationssorted?id=${id}`
        );
    }

    getEducations() {
        return axios.get(`http://localhost:8080/api/educations/geteudcations`);
    }
}
