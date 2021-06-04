package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.SocialMediaService;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.core.utilities.results.SuccessResult;
import com.emin.hrms.dataAccess.abstracts.SocialMediaDao;
import com.emin.hrms.entities.concretes.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialMediaManager implements SocialMediaService {

    private SocialMediaDao socialMediaDao;

    @Autowired
    public SocialMediaManager(SocialMediaDao socialMediaDao) {
        this.socialMediaDao = socialMediaDao;
    }

    @Override
    public Result addSocialMedia(SocialMedia socialMedia) {
        this.socialMediaDao.save(socialMedia);
        return new SuccessResult("Sosyal medya eklemesi başarılı.");
    }
}
