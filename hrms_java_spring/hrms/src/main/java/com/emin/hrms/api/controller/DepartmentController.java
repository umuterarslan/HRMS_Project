package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.DepartmentService;
import com.emin.hrms.business.abstracts.SchoolsService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.Department;
import com.emin.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/adddepartment")
    public Result addDepartment(@RequestBody Department department) {
        return this.departmentService.addDepartment(department);
    }

    @GetMapping("/getdepartments")
    public DataResult<List<Department>> getDepartments() {
        return this.departmentService.getDepartments();
    }

}
