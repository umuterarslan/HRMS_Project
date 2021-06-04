package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.Language;
import com.emin.hrms.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {

    DataResult<List<ProgrammingLanguage>> getProgrammingLanguages();

    Result addProgrammingLanguage(ProgrammingLanguage programmingLanguage);

}
