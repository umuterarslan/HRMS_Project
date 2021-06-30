package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.TechnologieService;
import com.emin.hrms.core.dtoConverter.DtoConverterService;
import com.emin.hrms.core.utilities.IsFull;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.TechnologieDao;
import com.emin.hrms.entities.concretes.Technology;
import com.emin.hrms.entities.dtos.addDtos.TechnologyAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologieManager implements TechnologieService {

    private TechnologieDao programmingLanguageDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public TechnologieManager(TechnologieDao programmingLanguageDao, DtoConverterService dtoConverterService) {
        this.programmingLanguageDao = programmingLanguageDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<Technology>> getTechnologies() {
        if (IsFull.listController(this.programmingLanguageDao.findAll())) {
            return new SuccessDataResult<>(this.programmingLanguageDao.findAll(),"Programlama dilleri listelemesi başarılı.");
        } else {
            return new ErrorDataResult<>(null, "Listelenecek programlama dili bulunamadı!");
        }
    }

    @Override
    public Result addTechnologie(TechnologyAddDto programmingLanguage) {
        this.programmingLanguageDao.save((Technology) this.dtoConverterService.dtoClassConverter(programmingLanguage, Technology.class));
        return new SuccessResult("Programlama dili ekleme başarılı.");
    }
}
