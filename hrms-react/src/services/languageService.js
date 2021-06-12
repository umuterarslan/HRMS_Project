import axios from "axios";

export default class LanguageService {
    addLanguage(language) {
        axios({
            method: "POST",
            url: "http://localhost:8080/api/languages/addlanguage",
            data: language,
            headers: "content-type: application/json",
        });
    }

    getLanguages() {
        return axios.get("http://localhost:8080/api/languages/getlanguages");
    }
}
