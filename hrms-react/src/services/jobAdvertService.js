import axios from "axios";

export default class JobAdvertService {
    getJobAdverts() {
        return axios.get(`http://localhost:8080/api/jobadverts/getJobAdverts`);
    }

    getActiveJobAdverts() {
        return axios.get(
            "http://localhost:8080/api/jobadverts/getActiveJobAdverts"
        );
    }

    getActiveJobAdvertsSorted(state) {
        return axios.get(
            `http://localhost:8080/api/jobadverts/getActiveJobAdvertsSorted?is%20desc=${state}`
        );
    }

    addJobAdvert(jobAdvert) {
        return axios({
            method: "POST",
            url: `http://localhost:8080/api/jobadverts/addJobAdvert`,
            data: jobAdvert,
            headers: "content-type: application/json",
        });
    }

    getJobAdvertById(id) {
        return axios.get(
            `http://localhost:8080/api/jobadverts/getjobadvertyid?id=${id}`
        );
    }

    getJobAdvertByCompanyName(name) {
        return axios.get(
            `http://localhost:8080/api/jobadverts/getJobAdvertsForCompanyName?companyName=${name}`
        );
    }

    deleteJobAdvertById(id) {
        return axios.delete(
            `http://localhost:8080/api/jobadverts/deletejobadvertbyid?id=${id}`
        );
    }

    changeChangeJobAdvert(id, state) {
        return axios.post(
            `http://localhost:8080/api/jobadverts/changeActiveJobAdvert?${id}=1&state=${state}`
        );
    }

    changeIsConfirmedJobAdvert(id, state) {
        return axios.get(
            `http://localhost:8080/api/jobadverts/changeconfirmedjobadvert?id=${id}&state=${state}`
        );
    }

    getJobAdvertByIsActiveTrueAndIsConfirmedTrueSorted(state) {
        return axios
            .get(
                `http://localhost:8080/api/jobadverts/getjobadvertbyisactivetrueandisconfirmedtruesorted?isDesc=${state}`
            )
            .then((res) => {
                return res;
            })
            .catch((err) => {
                return err;
            });
    }

    getJobAdvertByIsActiveTrueAndIsConfirmedTrue() {
        return axios.get(`http://localhost:8080/api/jobadverts/getjobadvertbyisactivetrueandisconfirmedtrue
        `);
    }
}
