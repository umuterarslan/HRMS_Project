package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.EducationService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.Education;
import com.emin.hrms.entities.dtos.addDtos.EducationAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {

    private EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping("/addeducation")
    public Result eddEducation(@RequestBody EducationAddDto educationAddDto) {
        return this.educationService.addEducation(educationAddDto);
    }

    @GetMapping("/geteudcations")
    public DataResult<List<Education>> getEducations() {
        return this.educationService.getEducations();
    }

    @GetMapping("/geteducationssorted")
    public DataResult getEducationSorted(int id) {
        return this.educationService.getAllSorted(id);
    }

    @DeleteMapping("/deleteeeducationbyid")
    public Result deleteEducationById(@RequestParam int id) {
        return this.educationService.deleteEducationById(id);
    }

    @GetMapping("/geteducationbycurriculavitaeid")
    public DataResult getEducationByCurriculaVitaeId(@RequestParam int id) {
        return this.educationService.getEducationByCurriculaVitaeId(id);
    }

}
