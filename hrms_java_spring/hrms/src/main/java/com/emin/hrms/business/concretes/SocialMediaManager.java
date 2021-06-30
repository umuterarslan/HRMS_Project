package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.SocialMediaService;
import com.emin.hrms.core.dtoConverter.DtoConverterService;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.core.utilities.results.SuccessResult;
import com.emin.hrms.dataAccess.abstracts.SocialMediaDao;
import com.emin.hrms.entities.concretes.SocialMedia;
import com.emin.hrms.entities.dtos.addDtos.SocialMediaAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialMediaManager implements SocialMediaService {

    private SocialMediaDao socialMediaDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public SocialMediaManager(SocialMediaDao socialMediaDao, DtoConverterService dtoConverterService){
        this.socialMediaDao = socialMediaDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addSocialMedia(SocialMediaAddDto socialMediaAddDto) {
        this.socialMediaDao.save((SocialMedia) this.dtoConverterService.dtoClassConverter(socialMediaAddDto, SocialMedia.class));
        return new SuccessResult("Sosyal medya eklemesi başarılı.");
    }
}
