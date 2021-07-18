package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.BusinessLife;
import com.emin.hrms.entities.dtos.addDtos.BusinessLifeAddDto;

import java.util.List;

public interface BusinessLifeService {

    Result addBusinessLife(BusinessLifeAddDto businessLifeAddDto);

    DataResult<List<BusinessLife>> getBusinessLifeEndDateByCurriculaVitaeId(int id);

    Result updateBusinessLife (BusinessLife businessLife);

    Result deleteBusinessLifeById(int id);

}
