import axios from "axios";

export default class CurriculaVitaeService {
    addCv(curriculaVitae) {
        axios({
            method: "POST",
            url: "http://localhost:8080/api/curriculavitae/addcv",
            data: CurriculaVitaeService,
            headers: "content-type: application/json",
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
