import axios from "axios";

export default class JobSeekerLanguageService {
    addJobSeekerLanguage(jobSeekerLanguage) {
        axios({
            method: "POST",
            url: "http://localhost:8080/api/jobseekerlanguage/addjobseekerlanguage",
            data: jobSeekerLanguage,
            headers: "content-type: application/json",
        });
    }
}
