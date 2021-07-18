package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.TechnologyService;
import com.emin.hrms.core.dtoConverter.DtoConverterService;
import com.emin.hrms.core.utilities.IsFull;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.TechnologyDao;
import com.emin.hrms.entities.concretes.Technology;
import com.emin.hrms.entities.dtos.addDtos.TechnologyAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologieManager implements TechnologyService {

    private TechnologyDao technologyDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public TechnologieManager(TechnologyDao technologyDao, DtoConverterService dtoConverterService) {
        this.technologyDao = technologyDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<Technology>> getTechnologies() {
        if (IsFull.listController(this.technologyDao.findAll())) {
            return new SuccessDataResult<>(this.technologyDao.findAll(),"Teknolojiler listelemesi başarılı.");
        } else {
            return new ErrorDataResult<>(null, "Listelenecek teknoloji bulunamadı!");
        }
    }

    @Override
    public Result addTechnologie(TechnologyAddDto programmingLanguage) {
        this.technologyDao.save((Technology) this.dtoConverterService.dtoClassConverter(programmingLanguage, Technology.class));
        return new SuccessResult("Teknoloji ekleme başarılı.");
    }

    @Override
    public Result deleteTechnology(int id) {
        this.technologyDao.deleteTechnologyById(id);
        return new SuccessResult("Teknoloji silme başarılı.");
    }
}
