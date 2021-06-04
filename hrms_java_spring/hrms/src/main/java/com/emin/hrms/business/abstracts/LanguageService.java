package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.Language;
import com.emin.hrms.entities.concretes.School;


import java.util.List;

public interface LanguageService {

    DataResult<List<Language>> getLanguages();

    Result addLanguage(Language language);

}
