package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.dtos.addDtos.JobSeekerLanguageAddDto;

public interface JobSeekerLanguageService {

    Result addJobSeekerLanguage(JobSeekerLanguageAddDto jobSeekerLanguageAddDto);

}
