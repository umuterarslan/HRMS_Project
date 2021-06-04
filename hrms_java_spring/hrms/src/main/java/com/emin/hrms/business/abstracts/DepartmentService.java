package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.Department;

import java.util.List;

public interface DepartmentService {

    DataResult<List<Department>> getDepartments();

    Result addDepartment(Department department);

}
