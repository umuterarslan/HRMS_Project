package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.EmployerUpdateRequestService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.EmployerUpdateRequest;
import com.emin.hrms.entities.dtos.addDtos.EmployerUpdateRequestAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employerupdaterequest")
@CrossOrigin
public class EmployerUpdateRequestController {

    private EmployerUpdateRequestService employerUpdateRequestService;

    @Autowired
    public EmployerUpdateRequestController(EmployerUpdateRequestService employerUpdateRequestService) {
        this.employerUpdateRequestService = employerUpdateRequestService;
    }

    @PostMapping("/addemployerupdaterequest")
    public Result addEmployerUpdateRequest(@RequestBody EmployerUpdateRequestAddDto employerUpdateRequestAddDto) {
        return this.employerUpdateRequestService.addEmployerUpdateRequest(employerUpdateRequestAddDto);
    }

    @GetMapping("/getallemployerupdaterequest")
    public DataResult<List<EmployerUpdateRequest>> getAllEmployerUpdateRequest() {
        return this.employerUpdateRequestService.getAllEmployerUpdateRequest();
    }

    @GetMapping("/getemployerupdaterequestbyemployerid")
    public DataResult<EmployerUpdateRequest> getEmployerUpdateRequestByEmployerId(@RequestParam int id) {
        return this.employerUpdateRequestService.getEmployerUpdateRequestByEmployerId(id);
    }

    @DeleteMapping("/deleteemployerupdaterequestbyemployerid")
    public Result deleteEmployerUpdateRequestByEmployerId(@RequestParam int id) {
        return this.employerUpdateRequestService.deleteEmployerUpdateRequestById(id);
    }

}
