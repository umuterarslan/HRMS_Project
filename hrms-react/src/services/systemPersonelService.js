import axios from "axios";

export default class SystemPersonelService {
    getSystemPersonels() {
        return axios.get(
            "http://localhost:8080/api/systempersonels/getSystemPersonels"
        );
    }

    async addSystemPersonel(systemPersonel) {
        return await axios({
            method: "POST",
            url: `http://localhost:8080/api/systempersonels/addsystempersonel`,
            data: systemPersonel,
            headers: { "Content-Type": "application/json;charset=UTF-8" },
        })
            .then((res) => {
                return res;
            })
            .catch((err) => {
                return err.error.error;
            });
    }

    getSystemPersonelById(id) {
        return axios.get(
            `http://localhost:8080/api/systempersonels/getsystempersonelyid?id=${id}`
        );
    }

    deleteSystemPersonelById(id) {
        axios.delete(
            `http://localhost:8080/api/systempersonels/deletesystempersonelbyid?id=${id}`
        );
    }

    async updateSystemPersonel(id, email, username) {
        return await axios
            .put(
                `http://localhost:8080/api/systempersonels/updatesystempersonel?email=${email}&id=${id}&username=${username}`
            )
            .then((res) => {
                console.log(res);
                return res;
            })
            .catch((error) => {
                console.log(error);
                return error;
            });
    }
}
