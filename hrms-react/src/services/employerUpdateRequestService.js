import axios from "axios";

export default class EmployerUpdateRequestService {
    async addEmployerUpdateRequest(employerUpdateRequest) {
        return await axios({
            method: "POST",
            url: `http://localhost:8080/api/employerupdaterequest/addemployerupdaterequest`,
            data: employerUpdateRequest,
            headers: { "Content-Type": "application/json;charset=UTF-8" },
        });
    }

    async getAllEmployerUpdateRequest() {
        return await axios.get(
            `http://localhost:8080/api/employerupdaterequest/getallemployerupdaterequest`
        );
    }

    async deleteEmployerUpdateRequest(id) {
        return await axios.delete(
            `http://localhost:8080/api/employerupdaterequest/deleteemployerupdaterequestbyemployerid?id=${id}`
        );
    }

    async getEmployerUpdateRequestByEmployerId(id) {
        return await axios.get(
            `http://localhost:8080/api/employerupdaterequest/getemployerupdaterequestbyemployerid?id=${id}`
        );
    }
}
