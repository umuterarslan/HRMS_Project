package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.JobSeeker;
import com.emin.hrms.entities.concretes.SystemPersonel;

import java.util.List;

public interface SystemPersonelService {

    DataResult<List<SystemPersonel>> getSystemPersonels();

    Result addSystemPersonel(SystemPersonel systemPersonel);

    DataResult<SystemPersonel> getSystemPersonelById(int id);

    Result deleteSystemPersonelById(int id);

}
