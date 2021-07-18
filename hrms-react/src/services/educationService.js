import axios from "axios";

export default class EducationService {
    async addEducation(education) {
        console.log(education);
        return await axios({
            method: "POST",
            url: "http://localhost:8080/api/educations/addeducation",
            data: education,
            headers: { "Content-Type": "application/json;charset=UTF-8" },
        })
            .then((res) => {
                return res.data.message;
            })
            .catch((err) => {
                return err;
            });
    }

    async getEducationSortedById(id) {
        return await axios.get(
            `http://localhost:8080/api/educations/geteducationssorted?id=${id}`
        );
    }

    getEducations() {
        return axios.get(`http://localhost:8080/api/educations/geteudcations`);
    }

    async deleteEducationById(id) {
        return await axios.delete(
            `http://localhost:8080/api/educations/deleteeeducationbyid?id=${id}`
        );
    }
}
