package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.ProgrammingLanguageService;
import com.emin.hrms.core.utilities.IsFull;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.ProgrammingLanguageDao;
import com.emin.hrms.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageDao programmingLanguageDao;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao) {
        this.programmingLanguageDao = programmingLanguageDao;
    }

    @Override
    public DataResult<List<ProgrammingLanguage>> getProgrammingLanguages() {
        if (IsFull.listController(this.programmingLanguageDao.findAll())) {
            return new SuccessDataResult<>(this.programmingLanguageDao.findAll(),"Programlama dilleri listelemesi başarılı.");
        } else {
            return new ErrorDataResult<>(null, "Listelenecek programlama dili bulunamadı!");
        }
    }

    @Override
    public Result addProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguageDao.save(programmingLanguage);
        return new SuccessResult("Programlama dili ekleme başarılı.");
    }
}
