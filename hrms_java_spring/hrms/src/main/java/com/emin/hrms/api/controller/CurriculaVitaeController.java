package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.CurriculaVitaeService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.CurriculaVitae;
import com.emin.hrms.entities.dtos.addDtos.CurriculaVitaeAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/curriculavitae")
@CrossOrigin
public class CurriculaVitaeController {

    private CurriculaVitaeService curriculaVitaeService;

    @Autowired
    public CurriculaVitaeController(CurriculaVitaeService curriculaVitaeService) {
        this.curriculaVitaeService = curriculaVitaeService;
    }

    @PostMapping("/addcv")
    public Result addCv(@RequestBody CurriculaVitaeAddDto curriculaVitaeAddDto) {
        return this.curriculaVitaeService.addCv(curriculaVitaeAddDto);
    }

    @GetMapping("/listcvbyjobseekerid")
    public DataResult<CurriculaVitae> getByJobSeekerId(@RequestParam("Jobseeker Id") int id) {
        return this.curriculaVitaeService.getByJobSeekerId(id);
    }

    @PostMapping("/addcvpicture")
    public Result addPicture(int jobSeekerId,MultipartFile file) throws IOException {
        return this.curriculaVitaeService.uploadPicture(jobSeekerId,file);
    }

    @PutMapping("/updatecv")
    public Result updateCv(@RequestBody CurriculaVitae curriculaVitae) {
        return this.curriculaVitaeService.updateCv(curriculaVitae);
    }

}
