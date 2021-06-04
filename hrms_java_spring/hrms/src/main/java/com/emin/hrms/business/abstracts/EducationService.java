package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.Education;

import java.util.List;

public interface EducationService {

    DataResult<List<Education>> getEducations();

    Result addEducation(Education education);

}
