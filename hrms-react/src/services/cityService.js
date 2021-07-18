import axios from "axios";

export default class CityService {
    async getCities() {
        return await axios.get(`http://localhost:8080/api/cities/getCities`);
    }
}
