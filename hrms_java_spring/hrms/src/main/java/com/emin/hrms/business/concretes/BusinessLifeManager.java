package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.BusinessLifeService;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.core.utilities.results.SuccessResult;
import com.emin.hrms.dataAccess.abstracts.BusinessLifeDao;
import com.emin.hrms.entities.concretes.BusinessLife;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
