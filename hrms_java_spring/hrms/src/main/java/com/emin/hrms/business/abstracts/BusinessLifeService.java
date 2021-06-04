package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.BusinessLife;
import com.emin.hrms.entities.concretes.Language;

public interface BusinessLifeService {

    Result addBusinessLife(BusinessLife businessLife);

}
