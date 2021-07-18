package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.TechnologyService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.Technology;
import com.emin.hrms.entities.dtos.addDtos.TechnologyAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
@CrossOrigin
public class TechnologieController {

    private TechnologyService technologieService;

    @Autowired
    public TechnologieController(TechnologyService technologieService) {
        this.technologieService = technologieService;
    }

    @PostMapping("/addtechnologie")
    public Result addSchool(@RequestBody TechnologyAddDto technologies) {
        return this.technologieService.addTechnologie(technologies);
    }

    @GetMapping("/gettechnologies")
    public DataResult<List<Technology>> getTechnologies() {
        return this.technologieService.getTechnologies();
    }

    @DeleteMapping("/deletetechnology")
    public Result deleteTechnology(@RequestParam int id) {
        return this.technologieService.deleteTechnology(id);
    }

}
