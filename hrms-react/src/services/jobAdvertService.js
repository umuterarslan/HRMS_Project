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

    async getActiveJobAdvertsSortedAsc(pageNo, pageSize) {
        return await axios.get(
            `http://localhost:8080/api/jobadverts/getjobadvertbyisactivetrueandisconfirmedtrueandpageableasc?pageNo=${pageNo}&pageSize=${pageSize}`
        );
    }

    async getActiveJobAdvertsSortedDesc(pageNo, pageSize) {
        return await axios.get(
            `http://localhost:8080/api/jobadverts/getjobadvertbyisactivetrueandisconfirmedtrueandpageabledesc?pageNo=${pageNo}&pageSize=${pageSize}`
        );
    }

    async addJobAdvert(jobAdvert) {
        return await axios({
            method: "POST",
            url: `http://localhost:8080/api/jobadverts/addJobAdvert`,
            data: jobAdvert,
            headers: { "Content-Type": "application/json;charset=UTF-8" },
        })
            .then((res) => {
                return res.data.message;
            })
            .catch((err) => {
                return err.error.error;
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

    async getJobAdvertByIsActiveTrueAndIsConfirmedTrue() {
        return await axios.get(`http://localhost:8080/api/jobadverts/getjobadvertbyisactivetrueandisconfirmedtrue
        `);
    }

    async getNumberOfJobAdvertsByEmployerId(id) {
        return await axios.get(
            `http://localhost:8080/api/jobadverts/countactiveandconfirmedbyemployerid?id=${id}`
        );
    }

    async getNumberOfAllJobAdverts() {
        return await axios.get(`http://localhost:8080/api/jobadverts/countallactiveandconfirmed
        `);
    }

    async getActiveAndConfirmedByEmployerId(id) {
        return await axios.get(
            `http://localhost:8080/api/jobadverts/getactiveandconfirmedbyemployerid?id=${id}`
        );
    }

    async getActiveAndConfirmedPageable(pageNo, pageSize) {
        return await axios.get(
            `http://localhost:8080/api/jobadverts/getjobadvertbyactiveandconfirmedpageable?pageNo=${pageNo}&pageSize=${pageSize}`
        );
    }
}
