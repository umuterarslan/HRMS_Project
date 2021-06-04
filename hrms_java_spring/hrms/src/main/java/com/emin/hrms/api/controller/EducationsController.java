package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.EducationService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.Education;
import com.emin.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationsController {

    private EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping("/addeducation")
    public Result eddEducation(@RequestBody Education education) {
        return this.educationService.addEducation(education);
    }

    @GetMapping("/geteucations")
    public DataResult<List<Education>> getEducations() {
        return this.educationService.getEducations();
    }

}
