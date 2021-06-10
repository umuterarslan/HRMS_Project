package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.EmployerService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployerController {

    private final EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getemployers")
    public DataResult<List<Employer>> getEmployers() {
        return this.employerService.getEmployers();
    }

    @PostMapping("/addemployer")
    public Result addEmployer(@RequestBody Employer employer) {
        return employerService.addEmployer(employer);
    }

    @GetMapping("/getemployerbyid")
    public DataResult<Employer> getEmployerById(int id) {
        return this.employerService.getEmployerById(id);
    }

    @DeleteMapping("/deleteemployerbyid")
    public Result deleteEmployerById(@RequestParam int id) {
        return this.employerService.deleteEmployerById(id);
    }

}
