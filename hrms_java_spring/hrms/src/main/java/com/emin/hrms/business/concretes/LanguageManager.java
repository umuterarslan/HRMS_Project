package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.LanguageService;
import com.emin.hrms.core.utilities.IsFull;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.LanguageDao;
import com.emin.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public DataResult<List<Language>> getLanguages() {
        if (IsFull.listController(this.languageDao.findAll())) {
            return new SuccessDataResult<>(this.languageDao.findAll(),"Diller listelendi");
        } else {
            return new ErrorDataResult<>(null,"Listelenecek dil bulunamadı!");
        }
    }

    @Override
    public Result addLanguage(Language language) {
        this.languageDao.save(language);
        return new SuccessResult("Dil ekleme başarılı.");
    }
}
