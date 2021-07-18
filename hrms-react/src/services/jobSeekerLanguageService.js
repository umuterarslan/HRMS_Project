import axios from "axios";

export default class JobSeekerLanguageService {
    async addJobSeekerLanguage(jobSeekerLanguage) {
        return await axios({
            method: "POST",
            url: "http://localhost:8080/api/jobseekerlanguage/addjobseekerlanguage",
            data: jobSeekerLanguage,
            headers: { "Content-Type": "application/json;charset=UTF-8" },
        })
            .then((res) => {
                return res.data.message;
            })
            .catch((err) => {
                return err;
            });
    }

    async deleteJobSeekerLanguage(id) {
        return await axios.delete(
            `http://localhost:8080/api/jobseekerlanguage/deletejobseekerlanguage?id=${id}`
        );
    }
}
