package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.SchoolsService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.ErrorDataResult;
import com.emin.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {

    private SchoolsService schoolsService;

    @Autowired
    public SchoolsController(SchoolsService schoolsService) {
        this.schoolsService = schoolsService;
    }

    @PostMapping("/addschool")
    public ResponseEntity<?> addSchool(@RequestBody School school) {
        return ResponseEntity.ok(this.schoolsService.addSchool(school));
    }

    @GetMapping("/getschools")
    public DataResult<List<School>> getSchools() {
        return this.schoolsService.getSchools();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları.");
        return errors;
    }

}
