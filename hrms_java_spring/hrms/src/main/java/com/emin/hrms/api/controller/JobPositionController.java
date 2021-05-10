package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.JobPositionService;
import com.emin.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getpositions")
    public List<JobPosition> getPositions() {
        return this.jobPositionService.getPositions();
    }
}