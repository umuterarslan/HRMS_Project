package com.emin.hrms.mernisValidator;

import com.emin.hrms.entities.concretes.JobSeeker;
import com.emin.hrms.core.services.MernisCheckService;
import org.springframework.stereotype.Service;

@Service
public class MernisValidatorManager implements MernisCheckService {

    @Override
    public boolean isMernis(JobSeeker jobSeeker) {
        return jobSeeker.getIdentityNumber().length() == 11;
    }

}
