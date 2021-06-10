import axios from "axios";

export default class SystemPersonelService {
    getSystemPersonels() {
        return axios.get(
            "http://localhost:8080/api/systempersonels/getSystemPersonels"
        );
    }

    addSystemPersonel(systemPersonel) {
        axios({
            method: "POST",
            url: "http://localhost:8080/api/systempersonels/addsystempersonel",
            data: systemPersonel,
        });
    }

    getSystemPersonelById(id) {
        return axios.get(
            "http://localhost:8080/api/systempersonels/getsystempersonelyid?id=" +
                { id }
        );
    }

    deleteSystemPersonelById(id) {
        axios.delete(
            "http://localhost:8080/api/systempersonels/deletesystempersonelbyid?id=" +
                { id }
        );
    }
}
