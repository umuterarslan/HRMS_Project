package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.BusinessLife;
import com.emin.hrms.entities.concretes.Education;
import com.emin.hrms.entities.concretes.Language;

import java.util.List;

public interface BusinessLifeService {

    Result addBusinessLife(BusinessLife businessLife);

    DataResult<List<BusinessLife>> getBusinessLifeEndDateByCurriculaVitaeId(int id);

}
