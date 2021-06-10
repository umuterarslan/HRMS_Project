package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.Employer;
import com.emin.hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {

    DataResult<List<JobSeeker>> getJobSeekers();

    Result addJobSeeker(JobSeeker jobSeeker);

    DataResult<JobSeeker> getJobSeekerById(int id);

    Result deleteJobSeekerById(int id);

}
