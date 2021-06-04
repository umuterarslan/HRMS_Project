package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.SchoolsService;
import com.emin.hrms.core.utilities.IsFull;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.SchoolDao;
import com.emin.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolsService {

    private SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public DataResult<List<School>> getSchools() {
        if (IsFull.listController(this.schoolDao.findAll())) {
            return new SuccessDataResult<>(this.schoolDao.findAll(),"Okul listeleme başarılı.");
        } else {
            return new ErrorDataResult<>(null, "Listelenecek okul bulunamadı!");
        }
    }

    @Override
    public Result addSchool(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("Okul ekleme başarılı.");
    }
}
