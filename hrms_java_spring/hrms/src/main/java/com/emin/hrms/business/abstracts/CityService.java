package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {

    DataResult<List<City>> getCities();

}
