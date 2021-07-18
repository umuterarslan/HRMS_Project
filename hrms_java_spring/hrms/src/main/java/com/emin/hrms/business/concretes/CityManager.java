package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.CityService;
import com.emin.hrms.core.utilities.IsFull;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.ErrorDataResult;
import com.emin.hrms.core.utilities.results.SuccessDataResult;
import com.emin.hrms.dataAccess.abstracts.CityDao;
import com.emin.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getCities() {
        if (IsFull.listController(this.cityDao.findAll())) {
            return new SuccessDataResult<>(this.cityDao.findAll(), "Şehirler listelemesi başarılı.");
        } else {
            return new ErrorDataResult<>(null, "Listelenecek şehir bulunamadı!");
        }
    }
}
