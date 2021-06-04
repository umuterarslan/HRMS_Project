package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.SchoolsService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.JobSeeker;
import com.emin.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cvs")
public class SchoolsController {

    private SchoolsService schoolsService;

    @Autowired
    public SchoolsController(SchoolsService schoolsService) {
        this.schoolsService = schoolsService;
    }

    @PostMapping("/addschool")
    public Result addSchool(@RequestBody School school) {
        return this.schoolsService.addSchool(school);
    }

    @GetMapping("/getschools")
    public DataResult<List<School>> getSchools() {
        return this.schoolsService.getSchools();
    }

}
