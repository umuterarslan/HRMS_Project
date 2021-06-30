import axios from "axios";

export default class DepartmentService {
    addDepartment(department) {
        return axios({
            method: "POST",
            url: "http://localhost:8080/api/departments/adddepartment",
            data: department,
            headers: "content-type: application/json",
        });
    }

    getDepartments() {
        return axios.get(
            "http://localhost:8080/api/departments/getdepartments"
        );
    }
}
