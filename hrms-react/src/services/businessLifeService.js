import axios from "axios";

export default class BusinlessLifeService {
    async addBusinessLife(businessLife) {
        return await axios({
            method: "POST",
            url: "http://localhost:8080/api/businesslife/addBusinessLife",
            data: businessLife,
            headers: { "Content-Type": "application/json;charset=UTF-8" },
        })
            .then((res) => {
                return res.data.message;
            })
            .catch((err) => {
                return err;
            });
    }

    async getBusinessLifeSortedById(id) {
        return await axios.get(
            `http://localhost:8080/api/businesslife/getbusinesslifessorted?id=${id}`
        );
    }

    async deleteBusinessLife(id) {
        return await axios.delete(
            `http://localhost:8080/api/businesslife/deletebusinesslifebyid?id=${id}`
        );
    }
}
