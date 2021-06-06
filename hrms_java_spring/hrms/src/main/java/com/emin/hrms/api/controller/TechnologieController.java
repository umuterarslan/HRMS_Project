package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.TechnologieService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.Technologie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
@CrossOrigin
public class TechnologieController {

    private TechnologieService technologieService;

    @Autowired
    public TechnologieController(TechnologieService technologieService) {
        this.technologieService = technologieService;
    }

    @PostMapping("/addtechnologie")
    public Result addSchool(@RequestBody Technologie technologies) {
        return this.technologieService.addTechnologie(technologies);
    }

    @GetMapping("/gettechnologies")
    public DataResult<List<Technologie>> getTechnologies() {
        return this.technologieService.getTechnologies();
    }

}
