package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.JobAdvertService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.JobAdvert;
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
    public DataResult<List<JobAdvert>> getByAllByIsActiveTrueSorted(@RequestParam("is desc") boolean isDesc) {
        return this.jobAdvertService.getAllByIsActiveTrue(isDesc);
    }

    @GetMapping("/getJobAdvertsForCompanyName")
    public DataResult<List<JobAdvert>> getActiveJobAdvertsForEmployer(String companyName) {
        return this.jobAdvertService.getActiveJobAdvertsForEmployer(companyName);
    }

    @PostMapping("/changeActiveJobAdvert")
    public Result changeActiveJobAdvert(@RequestParam("id") int jobAdvertId, @RequestParam("state") boolean state) {
        return this.jobAdvertService.changeActiveJobAdvert(jobAdvertId, state);
    }

    @PostMapping("/changeconfirmedjobadvert")
    public Result changeConfirmedJobAdvert(@RequestParam("id") int jobAdvertId, @RequestParam("state") boolean state) {
        return this.jobAdvertService.changeConfirmedJobAdvert(jobAdvertId, state);
    }

    @GetMapping("/getjobadvertyid")
    public DataResult<JobAdvert> getJobAdvertById(int id) {
        return this.jobAdvertService.getJobAdvertById(id);
    }

    @DeleteMapping("/deletejobadvertbyid")
    public Result deleteJobAdvertById(@RequestParam int id) {
        return this.jobAdvertService.deleteJobAdvertById(id);
    }

    @GetMapping("/getjobadvertbyisactivetrueandisconfirmedtrue")
    public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrue(boolean isDesc) {
        return this.jobAdvertService.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(isDesc);
    }

}


