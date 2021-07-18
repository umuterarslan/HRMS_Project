import axios from "axios";

export default class SchoolService {
    addSchool(school) {
        return axios({
            method: "POST",
            url: "http://localhost:8080/api/schools/addschool",
            data: school,
            headers: "content-type: application/json",
        });
    }

    async getSchools() {
        return await axios.get("http://localhost:8080/api/schools/getschools");
    }
}
