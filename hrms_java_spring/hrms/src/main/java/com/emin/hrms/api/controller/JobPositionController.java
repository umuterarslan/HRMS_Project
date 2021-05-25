package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.JobPositionService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionController {

    private final JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getpositions")
    public DataResult<List<JobPosition>> getPositions() {
        return this.jobPositionService.getPositions();
    }

    @PostMapping("/addposition")
    public Result addJobPosition(@RequestBody JobPosition jobPosition) {
        return jobPositionService.addJobPosition(jobPosition);
    }

}