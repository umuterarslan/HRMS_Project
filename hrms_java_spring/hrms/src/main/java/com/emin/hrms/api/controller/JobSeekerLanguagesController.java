package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.JobSeekerLanguageService;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.dtos.addDtos.JobSeekerLanguageAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobseekerlanguage")
@CrossOrigin
public class JobSeekerLanguagesController {

    private JobSeekerLanguageService jobSeekerLanguageService;

    @Autowired
    public JobSeekerLanguagesController(JobSeekerLanguageService jobSeekerLanguageService) {
        this.jobSeekerLanguageService = jobSeekerLanguageService;
    }

    @PostMapping("/addjobseekerlanguage")
    public Result addJobSeekerLanguage(@RequestBody JobSeekerLanguageAddDto jobSeekerLanguageAddDto) {
        return this.jobSeekerLanguageService.addJobSeekerLanguage(jobSeekerLanguageAddDto);
    }

    @DeleteMapping("/deletejobseekerlanguage")
    public Result deleteJobSeekerLanguage(@RequestParam int id) {
        return this.jobSeekerLanguageService.deleteJobSeekerLanguage(id);
    }

}
