package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.JobAdvert;

import java.util.List;

public interface JobAdvertService {

    DataResult<List<JobAdvert>> getJobAdverts();

    Result addJobAdvert(JobAdvert jobAdverts);

    DataResult<List<JobAdvert>> getActiveJobAdverts();

    DataResult<List<JobAdvert>> findAllByIsActiveTrue();

    DataResult<List<JobAdvert>> getActiveJobAdvertsForEmployer(String companyName);

    Result setPasiveJobAdvert(int jobAdvertId);

}
