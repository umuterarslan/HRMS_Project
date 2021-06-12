import axios from "axios";

export default class JobSeekerSerive {
    addJobSeeker(jobSeeker) {
        axios({
            method: "POST",
            url: "http://localhost:8080/api/jobseekers/addjobseeker",
            data: jobSeeker,
            headers: "content-type: application/json",
        });
    }

    deleteJobSeekerById(id) {
        axios.delete(
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
