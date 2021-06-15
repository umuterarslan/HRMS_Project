import axios from "axios";

export default class CurriculaVitaeService {
    async addCv(curriculaVitae) {
        return await axios({
            method: "POST",
            url: "http://localhost:8080/api/curriculavitae/addcv",
            data: CurriculaVitaeService,
            headers: { "Content-Type": "application/json;charset=UTF-8" },
        })
            .then((res) => {
                return res.data.message;
            })
            .catch((err) => {
                return err;
            });
    }

    addPictureToCv(picture, id) {
        axios({
            method: "POST",
            url: `http://localhost:8080/api/curriculavitae/addPicture?jobSeekerId=${id}`,
            data: picture,
            headers: "content-type: application/json",
        });
    }

    getCvByJobSeekerId(id) {
        return axios.get(
            `http://localhost:8080/api/curriculavitae/listcvbyjobseekerid?Jobseeker%20Id=${id}`
        );
    }
}
