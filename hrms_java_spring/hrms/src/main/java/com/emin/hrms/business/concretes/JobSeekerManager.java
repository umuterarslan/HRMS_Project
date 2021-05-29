package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.JobSeekerService;
import com.emin.hrms.core.services.MernisCheckService;
import com.emin.hrms.core.utilities.EmailValidator;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.JobSeekerDao;
import com.emin.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private MernisCheckService mernisCheckService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisCheckService mernisCheckService) {
        this.jobSeekerDao = jobSeekerDao;
        this.mernisCheckService = mernisCheckService;
    }

    @Override
    public DataResult<List<JobSeeker>> getJobSeekers() {
        return new SuccessDataResult<>(jobSeekerDao.findAll(), "İş arayanlar listelendi.");
    }

    @Override
    public Result addJobSeeker(JobSeeker jobSeeker) {
        try {
            if (!EmailValidator.emailFormatController(jobSeeker.getEmail())) {
                return new ErrorResult("Eposta formata uygun değil!");
            } else if (!mernisCheckService.isMernis(jobSeeker)) {
                return new ErrorResult("Kayıt olan kişinin kimlik numarası gerçek değil!");
            } else {
                this.jobSeekerDao.save(jobSeeker);
                return new SuccessResult("İş arayan olarak kayıt olundu! Eposta adresinizden üyeliğinizi onaylayınız.");
            }
        }catch (Exception e){
            if (e.getMessage()
                    .equals("could not execute statement; SQL [n/a]; constraint [uc_users_email]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement")) {
                return new ErrorResult("Kayıt olunmak istenilen eposta sistemde zaten kayıtlı!");
            } else {
                return new ErrorResult("Kimlik numarası sistemde zaten mevcut!");
            }
        }
    }

}
