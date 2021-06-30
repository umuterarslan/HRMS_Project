package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.BusinessLifeService;
import com.emin.hrms.core.dtoConverter.DtoConverterService;
import com.emin.hrms.core.utilities.IsFull;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.BusinessLifeDao;
import com.emin.hrms.entities.concretes.BusinessLife;
import com.emin.hrms.entities.dtos.addDtos.BusinessLifeAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessLifeManager implements BusinessLifeService {

    private BusinessLifeDao businessLifeDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public BusinessLifeManager(BusinessLifeDao businessLifeDao, DtoConverterService dtoConverterService) {
        this.businessLifeDao = businessLifeDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addBusinessLife(BusinessLifeAddDto businessLifeAddDto) {
        this.businessLifeDao.save((BusinessLife) this.dtoConverterService.dtoClassConverter(businessLifeAddDto, BusinessLife.class));
        return new SuccessResult("Kariyer bilgisi ekleme başarılı.");
    }

    @Override
    public DataResult<List<BusinessLife>> getBusinessLifeEndDateByCurriculaVitaeId(int id) {
        Sort sort = Sort.by(Sort.Direction.DESC,"endDate");
        if (IsFull.listController(this.businessLifeDao.getBusinessLifeEndDateByCurriculaVitaeId(id, sort))) {
            return new SuccessDataResult(this.businessLifeDao.getBusinessLifeEndDateByCurriculaVitaeId(id, sort), "İş hayatı bilgileri sıralı olarak listelendi.");
        } else {
            return new ErrorDataResult<>(null, "Listelenecek eğitim bilgileri bulunamadı!");
        }
    }

    @Override
    public Result updateBusinessLife(BusinessLife businessLife) {
        this.businessLifeDao.save(businessLife);
        return new SuccessResult("Güncelleme başarılı!");
    }
}
