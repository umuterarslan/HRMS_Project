import axios from "axios";

export default class SavedJobAdvertService {
    async addSavedJobAdvert(saved) {
        return await axios({
            method: "POST",
            url: `http://localhost:8080/api/savedjobadverts/addtosavedjobadverts`,
            data: saved,
            headers: { "Content-Type": "application/json;charset=UTF-8" },
        })
            .then((res) => {
                return res;
            })
            .catch((err) => {
                return err;
            });
    }

    async getSavedJobAdverts() {
        return await axios.get(
            `http://localhost:8080/api/savedjobadverts/getsavedjobadverts`
        );
    }

    async getSavedJobAdvertByJobSeekerId(id) {
        return await axios.get(
            `http://localhost:8080/api/savedjobadverts/getsavedjobadvertsbyjobseekerid?id=${id}`
        );
    }

    async deleteSavedJobAdvert(id) {
        return await axios.delete(
            `http://localhost:8080/api/savedjobadverts/deletesavedjobadvertbyid?id=${id}`
        );
    }
}
