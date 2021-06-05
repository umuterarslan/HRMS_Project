package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.BusinessLifeService;
import com.emin.hrms.core.utilities.IsFull;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.BusinessLifeDao;
import com.emin.hrms.entities.concretes.BusinessLife;
import com.emin.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessLifeManager implements BusinessLifeService {

    private BusinessLifeDao businessLifeDao;

    @Autowired
    public BusinessLifeManager(BusinessLifeDao businessLifeDao) {
        this.businessLifeDao = businessLifeDao;
    }

    @Override
    public Result addBusinessLife(BusinessLife businessLife) {
        return new SuccessResult("Kariyer bilgisi ekleme başarılı.");
    }

    @Override
    public DataResult<List<Education>> getAllSorted(int id) {
        Sort sort = Sort.by(Sort.Direction.DESC);
        if (IsFull.listController(this.businessLifeDao.getBusinessLifeEndDateByCurriculaVitaeId(id,sort))) {
            return new SuccessDataResult<>(this.businessLifeDao.getBusinessLifeEndDateByCurriculaVitaeId(id,sort),"İş hayatı bilgileri sıralı olarak listelendi.");
        } else {
            return new ErrorDataResult<>(null, "Listelenecek eğitim bilgileri bulunamadı!");
        }
    }
}
