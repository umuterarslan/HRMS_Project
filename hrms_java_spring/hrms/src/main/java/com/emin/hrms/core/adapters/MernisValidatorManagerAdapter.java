package com.emin.hrms.core.adapters;

import com.emin.hrms.core.services.MernisCheckService;
import com.emin.hrms.entities.concretes.JobSeeker;
import com.emin.hrms.mernisValidator.MernisValidatorManager;

public class MernisValidatorManagerAdapter implements MernisCheckService {

    private MernisValidatorManager mernisValidatorManager;

    public MernisValidatorManagerAdapter(MernisValidatorManager mernisValidatorManager) {
        this.mernisValidatorManager = mernisValidatorManager;
    }

    @Override
    public boolean isMernis(JobSeeker jobSeeker) {
        return this.mernisValidatorManager.isMernis(jobSeeker);
    }
}
