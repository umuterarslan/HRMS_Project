package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.TechnologieService;
import com.emin.hrms.core.utilities.IsFull;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.TechnologieDao;
import com.emin.hrms.entities.concretes.Technologie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologieManager implements TechnologieService {

    private TechnologieDao programmingLanguageDao;

    @Autowired
    public TechnologieManager(TechnologieDao programmingLanguageDao) {
        this.programmingLanguageDao = programmingLanguageDao;
    }

    @Override
    public DataResult<List<Technologie>> getTechnologies() {
        if (IsFull.listController(this.programmingLanguageDao.findAll())) {
            return new SuccessDataResult<>(this.programmingLanguageDao.findAll(),"Programlama dilleri listelemesi başarılı.");
        } else {
            return new ErrorDataResult<>(null, "Listelenecek programlama dili bulunamadı!");
        }
    }

    @Override
    public Result addTechnologie(Technologie programmingLanguage) {
        this.programmingLanguageDao.save(programmingLanguage);
        return new SuccessResult("Programlama dili ekleme başarılı.");
    }
}
