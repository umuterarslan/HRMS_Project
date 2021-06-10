package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.JobSeekerService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.core.utilities.results.SuccessResult;
import com.emin.hrms.entities.concretes.Employer;
import com.emin.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin
public class JobSeekersController {

    private final JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getjobseekers")
    public DataResult<List<JobSeeker>> getJobSeekers() {
        return this.jobSeekerService.getJobSeekers();
    }

    @PostMapping("/addjobseeker")
    public Result addJobSeeker(@RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerService.addJobSeeker(jobSeeker);
    }

    @GetMapping("/getjobseekeryid")
    public DataResult<JobSeeker> getJobSeekerById(int id) {
        return this.jobSeekerService.getJobSeekerById(id);
    }

    @DeleteMapping("/deletejobseekerbyid")
    public Result deleteEmployerById(@RequestParam int id) {
        return this.jobSeekerService.deleteJobSeekerById(id);
    }



}