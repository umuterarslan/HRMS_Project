package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.SystemPersonelService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.core.utilities.results.SuccessDataResult;
import com.emin.hrms.core.utilities.results.SuccessResult;
import com.emin.hrms.entities.concretes.JobSeeker;
import com.emin.hrms.entities.concretes.SystemPersonel;
import com.emin.hrms.entities.dtos.getDtos.SystemPersonelGetDto;
import com.emin.hrms.entities.dtos.updateDtos.SystemPersonelUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/systempersonels")
@CrossOrigin
public class SystemPersonelController {

    private SystemPersonelService systemPersonelService;

    @Autowired
    public SystemPersonelController(SystemPersonelService systemPersonelService) {
        this.systemPersonelService = systemPersonelService;
    }

    @PostMapping("/addsystempersonel")
    public Result addSystemPersonel(@RequestBody SystemPersonel systemPersonel){
        return this.systemPersonelService.addSystemPersonel(systemPersonel);
    }

    @GetMapping("/getSystemPersonels")
    public DataResult<List<SystemPersonel>> getSystemPersonels() {
        return this.systemPersonelService.getSystemPersonels();
    }

    @GetMapping("/getsystempersonelyid")
    public DataResult<SystemPersonel> getSystemPersonelById(int id) {
        return this.systemPersonelService.getSystemPersonelById(id);
    }

    @DeleteMapping("/deletesystempersonelbyid")
    public Result deleteSystemPersonelById(@RequestParam int id) {
        return this.systemPersonelService.deleteSystemPersonelById(id);
    }

    @PutMapping("/updatesystempersonel")
    public Result updateSystemPersonel(@RequestParam() int id, @RequestParam() String email, @RequestParam() String username) {
        return this.systemPersonelService.updateSystemPersonel(id, email, username);
    }

}
