package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.CurriculaVitae;
import com.emin.hrms.entities.concretes.Employer;
import com.emin.hrms.entities.dtos.updateDtos.EmployerUpdateDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployerService {

    DataResult<List<Employer>> getEmployers();

    Result addEmployer(Employer employer);

    Result updateEmployer(int id, String companyName, String email, String phoneNumber, String website);

    DataResult<Employer> getEmployerById(int id);

    Result deleteEmployerById(int id);

    Result uploadPicture(int employerId, MultipartFile file) throws IOException;

    Result setUpdateRequest(int id, Boolean bool);

}
