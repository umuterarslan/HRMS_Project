import axios from "axios";

export default class JobSeekerSerive {
    async addJobSeeker(jobSeeker) {
        return await axios({
            method: "POST",
            url: "http://localhost:8080/api/jobseekers/addjobseeker",
            data: jobSeeker,
            headers: { "Content-Type": "application/json;charset=UTF-8" },
        })
            .then((res) => {
                return res.data;
            })
            .catch((err) => {
                return err;
            });
    }

    deleteJobSeekerById(id) {
        return axios.delete(
            `http://localhost:8080/api/jobseekers/deletejobseekerbyid?id=${id}`
        );
    }

    getJobSeekers() {
        return axios.get("http://localhost:8080/api/jobseekers/getjobseekers");
    }

    getJobSeekerById(id) {
        return axios.get(
            `http://localhost:8080/api/jobseekers/getjobseekeryid?id=${id}`
        );
    }
}
