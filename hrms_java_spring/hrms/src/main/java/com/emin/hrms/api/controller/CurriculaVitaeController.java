package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.CurriculaVitaeService;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.CurriculaVitae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/curriculavitae")
public class CurriculaVitaeController {

    private CurriculaVitaeService curriculaVitaeService;

    @Autowired
    public CurriculaVitaeController(CurriculaVitaeService curriculaVitaeService) {
        this.curriculaVitaeService = curriculaVitaeService;
    }

    public Result addCv(@RequestBody CurriculaVitae curriculaVitae) {
        return this.curriculaVitaeService.addCv(curriculaVitae);
    }

}
