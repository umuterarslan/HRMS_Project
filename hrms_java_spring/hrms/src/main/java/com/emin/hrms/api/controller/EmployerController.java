package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.EmployerService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("/addemployerpicture")
    public Result addEmployerPicture(int employerId, MultipartFile file) throws IOException {
        return this.employerService.uploadPicture(employerId, file);
    }

    @PutMapping("/updateemployer")
    public Result updateEmployer(@RequestParam int id, @RequestParam String companyName, @RequestParam String email, @RequestParam String phoneNumber, @RequestParam String website) {
        return this.employerService.updateEmployer(id, companyName, email, phoneNumber, website);
    }

    @PostMapping("/setupdaterequest")
    public Result setUpdateRequest(@RequestParam int id, @RequestParam Boolean bool) {
        return this.employerService.setUpdateRequest(id, bool);
    }
}
