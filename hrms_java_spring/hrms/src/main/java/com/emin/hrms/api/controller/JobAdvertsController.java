package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.JobAdvertService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.JobAdvert;
import com.emin.hrms.entities.concretes.SystemPersonel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
public class JobAdvertsController {

    private final JobAdvertService jobAdvertService;

    @Autowired
    public JobAdvertsController(JobAdvertService jobAdvertService) {
        this.jobAdvertService = jobAdvertService;
    }

    @GetMapping("/getJobAdverts")
    public DataResult<List<JobAdvert>> getJobAdverts() {
        return this.jobAdvertService.getJobAdverts();
    }

    @PostMapping("/addJobAdvert")
    public Result addEmployer(@RequestBody JobAdvert jobAdvert) {
        return this.jobAdvertService.addJobAdvert(jobAdvert);
    }

    @GetMapping("/getActiveJobAdverts")
    public DataResult<List<JobAdvert>> getActiveJobAdverts() {
        return this.jobAdvertService.getActiveJobAdverts();
    }

    @GetMapping("/getActiveJobAdvertsSorted")
    public DataResult<List<JobAdvert>> findByAllByIsActiveTrueSorted() {
        return this.jobAdvertService.findAllByIsActiveTrue();
    }

    @GetMapping("/getJobAdvertsForCompanyName")
    public DataResult<List<JobAdvert>> getActiveJobAdvertsForEmployer(String companyName) {
        return this.jobAdvertService.getActiveJobAdvertsForEmployer(companyName);
    }

    @PostMapping("/setPasiveJobAdvert")
    public Result setPasiveJobAdvert(@RequestParam("id") int jobAdvertId) {
        return this.jobAdvertService.setPasiveJobAdvert(jobAdvertId);
    }

    @GetMapping("/getjobadvertyid")
    public DataResult<JobAdvert> getJobAdvertById(int id) {
        return this.jobAdvertService.getJobAdvertById(id);
    }

    @DeleteMapping("/deletejobadvertbyid")
    public Result deleteJobAdvertById(@RequestParam int id) {
        return this.jobAdvertService.deleteJobAdvertById(id);
    }

}


