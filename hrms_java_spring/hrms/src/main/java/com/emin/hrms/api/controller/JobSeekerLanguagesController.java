package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.JobSeekerLanguageService;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.JobSeekerLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobseekerlanguage")
public class JobSeekerLanguagesController {

    private JobSeekerLanguageService jobSeekerLanguageService;

    @Autowired
    public JobSeekerLanguagesController(JobSeekerLanguageService jobSeekerLanguageService) {
        this.jobSeekerLanguageService = jobSeekerLanguageService;
    }

    @PostMapping("/addjobseekerlanguage")
    public Result addJobSeekerLanguage(@RequestBody JobSeekerLanguage jobseekerLanguage) {
        return this.jobSeekerLanguageService.addJobSeekerLanguage(jobseekerLanguage);
    }

}
