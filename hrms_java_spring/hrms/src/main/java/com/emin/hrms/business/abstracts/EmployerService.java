package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.CurriculaVitae;
import com.emin.hrms.entities.concretes.Employer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployerService {

    DataResult<List<Employer>> getEmployers();

    Result addEmployer(Employer employer);

    DataResult<Employer> getEmployerById(int id);

    Result deleteEmployerById(int id);

    Result uploadPicture(int employerId, MultipartFile file) throws IOException;

}
