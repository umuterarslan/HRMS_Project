import axios from "axios";

export default class EmployerService {
    async addEmployer(employer) {
        return await axios({
            method: "POST",
            url: "http://localhost:8080/api/employers/addemployer",
            data: employer,
            headers: { "Content-Type": "application/json;charset=UTF-8" },
        })
            .then((res) => {
                return res.data;
            })
            .catch((err) => {
                return err;
            });
    }

    // async updateEmployer(id, companyName, email, phoneNumber, website) {
    //     return await axios({
    //         method: "PUT",
    //         url: `http://localhost:8080/api/employers/updateemployer?companyName=${companyName}&email=${email}&id=${id}&phoneNumber=${phoneNumber}&website=${website}`,
    //         headers: {
    //             "Content-Type": "application/json;charset=UTF-8",
    //             "Access-Control-Allow-Origin": "*",
    //             "Access-Control-Allow-Methods":
    //                 "GET,PUT,POST,DELETE,PATCH,OPTIONS",
    //             "Access-Control-Allow-Headers":
    //                 "Origin, X-Requested-With, Content-Type, Accept",
    //         },
    //     });
    // }

    async updateEmployer(id, companyName, email, phoneNumber, website) {
        return await axios.put(
            `http://localhost:8080/api/employers/updateemployer?companyName=${companyName}&email=${email}&id=${id}&phoneNumber=${phoneNumber}&website=${website}`
        );
    }

    async addPictureToEmployer(id, picture) {
        await axios({
            method: "POST",
            url: `http://localhost:8080/api/employers/addemployerpicture?employerId=${id}`,
            data: picture,
            headers: { "Content-Type": "application/json;charset=UTF-8" },
        });
    }

    async deleteEmployerById(id) {
        return await axios.delete(
            `http://localhost:8080/api/employers/deleteemployerbyid?id=${id}`
        );
    }

    async getEmployerById(id) {
        return await axios.get(
            `http://localhost:8080/api/employers/getemployerbyid?id=${id}`
        );
    }

    async getEmployers() {
        return await axios.get(
            `http://localhost:8080/api/employers/getemployers`
        );
    }

    async setUpdateRequest(id, bool) {
        return await axios.post(
            `http://localhost:8080/api/employers/setupdaterequest?bool=${bool}&id=${id}`
        );
    }
}
