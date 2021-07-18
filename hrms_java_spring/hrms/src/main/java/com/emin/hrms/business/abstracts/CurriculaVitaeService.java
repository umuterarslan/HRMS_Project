package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.CurriculaVitae;
import com.emin.hrms.entities.dtos.addDtos.CurriculaVitaeAddDto;
import com.emin.hrms.entities.dtos.updateDtos.CurriculaVitaeCoverLetterUpdateDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CurriculaVitaeService {

    Result addCv(CurriculaVitaeAddDto curriculaVitaeAddDto);

    DataResult<CurriculaVitae> getByJobSeekerId(int id);

    Result uploadPicture(int cvId, MultipartFile file) throws IOException;

    Result updateCvCoverLetter(int id, String coverLetter);

}
