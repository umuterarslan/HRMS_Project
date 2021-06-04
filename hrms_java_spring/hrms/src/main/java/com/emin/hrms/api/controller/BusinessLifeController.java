package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.BusinessLifeService;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.BusinessLife;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/businesslife")
public class BusinessLifeController {

    private BusinessLifeService businessLifeService;

    @Autowired
    public BusinessLifeController(BusinessLifeService businessLifeService) {
        this.businessLifeService = businessLifeService;
    }

    @PostMapping("/addBusinessLife")
    public Result addBusinessLife(@RequestBody BusinessLife businessLife) {
        return this.businessLifeService.addBusinessLife(businessLife);
    }

}
