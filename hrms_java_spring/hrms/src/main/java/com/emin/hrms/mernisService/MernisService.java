package com.emin.hrms.mernisService;

import com.emin.hrms.entities.concretes.JobSeeker;
import com.emin.hrms.core.services.MernisCheckService;
import org.springframework.stereotype.Service;

@Service
public class MernisService implements MernisCheckService {


    @Override
    public boolean isMernis(JobSeeker jobSeeker) {
        return jobSeeker.getIdentityNumber().length() == 11;
    }
}
