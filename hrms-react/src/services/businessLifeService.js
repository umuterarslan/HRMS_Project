import axios from "axios";

export default class BusinlessLifeService {
    addBusinessLife(businessLife) {
        axios({
            method: "POST",
            url: "http://localhost:8080/api/businesslife/addBusinessLife",
            data: businessLife,
            headers: "content-type: application/json",
        });
    }

    getBusinessLifeSortedById(id) {
        return axios.get(
            "http://localhost:8080/api/businesslife/getbusinesslifessorted?id=" +
                { id }
        );
    }
}
