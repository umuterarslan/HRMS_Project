package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.EmployerUpdateRequest;
import com.emin.hrms.entities.dtos.addDtos.EmployerUpdateRequestAddDto;

import java.util.List;

public interface EmployerUpdateRequestService {

    Result addEmployerUpdateRequest(EmployerUpdateRequestAddDto employerUpdateRequestAddDto);

    DataResult<List<EmployerUpdateRequest>> getAllEmployerUpdateRequest();

    DataResult<EmployerUpdateRequest> getEmployerUpdateRequestByEmployerId(int id);

    Result deleteEmployerUpdateRequestById(int id);

}
