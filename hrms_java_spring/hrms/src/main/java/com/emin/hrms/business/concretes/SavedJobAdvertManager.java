package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.SavedJobAdvertService;
import com.emin.hrms.core.dtoConverter.DtoConverterService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.core.utilities.results.SuccessDataResult;
import com.emin.hrms.core.utilities.results.SuccessResult;
import com.emin.hrms.dataAccess.abstracts.SavedJobAdvertsDao;
import com.emin.hrms.entities.concretes.SavedJobAdverts;
import com.emin.hrms.entities.dtos.addDtos.SavedJobAdvertsAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavedJobAdvertManager implements SavedJobAdvertService {

    private SavedJobAdvertsDao savedJobAdvertsDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public SavedJobAdvertManager(SavedJobAdvertsDao savedJobAdvertsDao, DtoConverterService dtoConverterService) {
        this.savedJobAdvertsDao = savedJobAdvertsDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addSavedJobAdvert(SavedJobAdvertsAddDto savedJobAdvertsAddDto) {
        this.savedJobAdvertsDao.save((SavedJobAdverts) this.dtoConverterService.dtoClassConverter(savedJobAdvertsAddDto, SavedJobAdverts.class));
        return new SuccessResult("Kaydedilenler ilanlara ekleme başarılı.");
    }

    @Override
    public DataResult<List<SavedJobAdverts>> getSavedJobAdverts() {
        return new SuccessDataResult(this.savedJobAdvertsDao.findAll(),"Kaydedilen iş işlanları listeleme başarılı.");
    }

    @Override
    public DataResult<List<SavedJobAdverts>> getSavedJobAdvertsByJobSeekerId(int id) {
        return new SuccessDataResult<>(this.savedJobAdvertsDao.getSavedJobAdvertsByJobSeekerId(id));
    }

    @Override
    public Result deleteSavedJobAdvert(int id) {
        this.savedJobAdvertsDao.deleteById(id);
        return new SuccessResult("Kaydedilen iş ilanı silme başarılı.");
    }


}
