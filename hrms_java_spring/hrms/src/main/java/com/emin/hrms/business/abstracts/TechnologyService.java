package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.Technology;
import com.emin.hrms.entities.dtos.addDtos.TechnologyAddDto;

import java.util.List;

public interface TechnologyService {

    DataResult<List<Technology>> getTechnologies();

    Result addTechnologie(TechnologyAddDto programmingLanguage);

    Result deleteTechnology(int id);

}
