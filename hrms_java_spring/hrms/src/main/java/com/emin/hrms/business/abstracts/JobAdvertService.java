package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.JobAdvert;
import com.emin.hrms.entities.concretes.SystemPersonel;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.util.List;

public interface JobAdvertService {

    DataResult<List<JobAdvert>> getJobAdverts();

    Result addJobAdvert(JobAdvert jobAdverts);

    DataResult<List<JobAdvert>> getActiveJobAdverts();

    DataResult<List<JobAdvert>> getAllByIsActiveTrue(boolean isDesc);

    DataResult<List<JobAdvert>> getActiveJobAdvertsForEmployer(String companyName);

    DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrue(boolean isDesc);

    Result changeActiveJobAdvert(int jobAdvertId, boolean state);

    Result changeConfirmedJobAdvert(int jobAdvertId, boolean state);

    DataResult<JobAdvert> getJobAdvertById(int id);

    Result deleteJobAdvertById(int id);

}
