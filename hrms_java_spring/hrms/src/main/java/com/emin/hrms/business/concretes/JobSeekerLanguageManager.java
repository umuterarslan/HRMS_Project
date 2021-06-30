package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.JobSeekerLanguageService;
import com.emin.hrms.core.dtoConverter.DtoConverterService;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.core.utilities.results.SuccessResult;
import com.emin.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import com.emin.hrms.entities.concretes.JobSeekerLanguage;
import com.emin.hrms.entities.dtos.addDtos.JobSeekerLanguageAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {

    private JobSeekerLanguageDao jobSeekerLanguageDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public JobSeekerLanguageManager(JobSeekerLanguageDao jobSeekerLanguageDao, DtoConverterService dtoConverterService) {
        this.jobSeekerLanguageDao = jobSeekerLanguageDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addJobSeekerLanguage(JobSeekerLanguageAddDto jobSeekerLanguageAddDto) {
        this.jobSeekerLanguageDao.save((JobSeekerLanguage) this.dtoConverterService.dtoClassConverter(jobSeekerLanguageAddDto, JobSeekerLanguage.class));
        return new SuccessResult("Cv'ye dil ekleme başarılı.");
    }

}
