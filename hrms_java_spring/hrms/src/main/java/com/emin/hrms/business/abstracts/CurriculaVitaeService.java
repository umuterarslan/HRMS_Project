package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.CurriculaVitae;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CurriculaVitaeService {

    Result addCv(CurriculaVitae curriculaVitae);

    DataResult<CurriculaVitae> getByJobSeekerId(int id);

    Result uploadPicture(int cvId, MultipartFile file) throws IOException;

}
