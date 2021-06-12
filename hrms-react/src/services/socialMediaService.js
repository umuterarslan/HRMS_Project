import axios from "axios";

export default class SocialMediaService {
    addSocialMedia(socialMedia) {
        axios({
            method: "POST",
            url: "http://localhost:8080/api/socialmedias/addsocialmedia",
            data: socialMedia,
            headers: "content-type: application/json",
        });
    }
}
