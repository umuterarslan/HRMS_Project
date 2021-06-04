package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.JobSeekerLanguageService;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.core.utilities.results.SuccessResult;
import com.emin.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import com.emin.hrms.entities.concretes.JobSeekerLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {

    private JobSeekerLanguageDao jobSeekerLanguageDao;

    @Autowired
    public JobSeekerLanguageManager(JobSeekerLanguageDao jobSeekerLanguageDao) {
        this.jobSeekerLanguageDao = jobSeekerLanguageDao;
    }

    @Override
    public Result addJobSeekerLanguage(JobSeekerLanguage jobseekerLanguage) {
        this.jobSeekerLanguageDao.save(jobseekerLanguage);
        return new SuccessResult("Cv'ye dil ekleme başarılı.");
    }

}
