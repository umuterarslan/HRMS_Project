package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.LanguageService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.Language;
import com.emin.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguageController {

    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/addlanguage")
    public Result addLanguage(@RequestBody Language language) {
        return this.languageService.addLanguage(language);
    }

    @GetMapping("/getlanguages")
    public DataResult<List<Language>> getLanguages() {
        return this.languageService.getLanguages();
    }

}
