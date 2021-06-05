package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.EducationService;
import com.emin.hrms.core.utilities.IsFull;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.EducationDao;
import com.emin.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public DataResult<List<Education>> getEducations() {
        if (IsFull.listController(this.educationDao.findAll())) {
            return new SuccessDataResult<>(this.educationDao.findAll(),"Eğitim bilgileri listeleme başarılı.");
        } else {
            return new ErrorDataResult<>(null, "Listelenecek eğitim bilgileri bulunamadı!");
        }
    }

    @Override
    public Result addEducation(Education education) {
        this.educationDao.save(education);
        return new SuccessResult("Eğitim bilgileri ekleme başarılı.");
    }

    @Override
    public DataResult<List<Education>> getAllSorted(int id) {
        Sort sort = Sort.by(Sort.Direction.DESC);
        if (IsFull.listController(this.educationDao.getEducationEndDateByCurriculaVitaeId(id,sort))) {
            return new SuccessDataResult<>(this.educationDao.getEducationEndDateByCurriculaVitaeId(id,sort),"Eğitim bilgileri sıralı olarak listelendi.");
        } else {
            return new ErrorDataResult<>(null, "Listelenecek eğitim bilgileri bulunamadı!");
        }
    }

}
