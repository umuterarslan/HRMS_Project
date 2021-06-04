package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.ProgrammingLanguageService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.ProgrammingLanguage;
import com.emin.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguageController {

    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @PostMapping("/addprogramminglanguage")
    public Result addSchool(@RequestBody ProgrammingLanguage programmingLanguage) {
        return this.programmingLanguageService.addProgrammingLanguage(programmingLanguage);
    }

    @GetMapping("/getprogramminglanguages")
    public DataResult<List<ProgrammingLanguage>> getProgrammingLanguages() {
        return this.programmingLanguageService.getProgrammingLanguages();
    }

}
