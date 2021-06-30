package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.dtos.addDtos.SocialMediaAddDto;

public interface SocialMediaService {

    Result addSocialMedia(SocialMediaAddDto socialMediaAddDto);

}
