package com.emin.hrms.core.adapters;

import com.emin.hrms.core.services.MernisCheckService;
import com.emin.hrms.entities.concretes.JobSeeker;
import com.emin.hrms.mernisValidator.MernisValidatorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MernisValidatorManagerAdapter implements MernisCheckService {

    private MernisValidatorManager mernisValidatorManager;

    @Autowired
    public MernisValidatorManagerAdapter(MernisValidatorManager mernisValidatorManager) {
        this.mernisValidatorManager = mernisValidatorManager;
    }

    @Override
    public boolean isMernis(JobSeeker jobSeeker) {
        return this.mernisValidatorManager.isMernis(jobSeeker);
    }
}
