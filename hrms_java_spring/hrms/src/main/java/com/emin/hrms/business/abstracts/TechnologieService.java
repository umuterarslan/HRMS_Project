package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.Technologie;

import java.util.List;

public interface TechnologieService {

    DataResult<List<Technologie>> getTechnologies();

    Result addTechnologie(Technologie programmingLanguage);

}
