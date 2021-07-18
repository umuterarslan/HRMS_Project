import axios from "axios";

export default class CurriculaVitaeService {
    async addCv(curriculaVitae) {
        return await axios({
            method: "POST",
            url: "http://localhost:8080/api/curriculavitae/addcv",
            data: curriculaVitae,
            headers: { "Content-Type": "application/json;charset=UTF-8" },
        })
            .then((res) => {
                return res.data.message;
            })
            .catch((err) => {
                return err.error.error;
            });
    }

    async updateCvCoverLetter(id, coverLetter) {
        return await axios({
            method: "PUT",
            url: `http://localhost:8080/api/curriculavitae/updatecvcoverletter?coverLetter=${coverLetter}&id=${id}`,
            headers: { "Content-Type": "application/json;charset=UTF-8" },
        })
            .then((res) => {
                return res.data.message;
            })
            .catch((err) => {
                return err.error.error;
            });
    }

    async addPictureToCv(formData, id) {
        return await axios({
            method: "POST",
            url: `http://localhost:8080/api/curriculavitae/addcvpicture?cvId=${id}`,
            data: formData,
            headers: { "Content-Type": "multipart/form-data" },
        })
            .then((res) => {
                return res.data.message;
            })
            .catch((err) => {
                return err;
            });
    }

    getCvByJobSeekerId(id) {
        return axios.get(
            `http://localhost:8080/api/curriculavitae/listcvbyjobseekerid?Jobseeker%20Id=${id}`
        );
    }
}
