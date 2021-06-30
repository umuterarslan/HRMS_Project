package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.BusinessLifeService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.BusinessLife;
import com.emin.hrms.entities.dtos.addDtos.BusinessLifeAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/businesslife")
@CrossOrigin
public class BusinessLifeController {

    private BusinessLifeService businessLifeService;

    @Autowired
    public BusinessLifeController(BusinessLifeService businessLifeService) {
        this.businessLifeService = businessLifeService;
    }

    @PostMapping("/addBusinessLife")
    public Result addBusinessLife(@RequestBody BusinessLifeAddDto businessLifeAddDto) {
        return this.businessLifeService.addBusinessLife(businessLifeAddDto);
    }

    @GetMapping("/getbusinesslifessorted")
    public DataResult getBusinessLifeSorted(@RequestParam int id) {
        return this.businessLifeService.getBusinessLifeEndDateByCurriculaVitaeId(id);
    }

    @PutMapping("/updatebusinesslife")
    public Result updateBusinessLife(@RequestBody BusinessLife businessLife) {
        return this.businessLifeService.updateBusinessLife(businessLife);
    }

}
