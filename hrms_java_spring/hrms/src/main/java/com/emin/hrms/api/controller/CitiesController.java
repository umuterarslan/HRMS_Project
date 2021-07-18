package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.CityService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.entities.concretes.City;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {

    private CityService cityService;

    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getCities")
    public DataResult<List<City>> getCities() {
        return this.cityService.getCities();
    }

}
