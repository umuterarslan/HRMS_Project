package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.SavedJobAdvertService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.SavedJobAdverts;
import com.emin.hrms.entities.dtos.addDtos.SavedJobAdvertsAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/savedjobadverts")
@CrossOrigin
public class SavedJobAdvertsController {

    private SavedJobAdvertService savedJobAdvertService;

    @Autowired
    public SavedJobAdvertsController(SavedJobAdvertService savedJobAdvertService) {
        this.savedJobAdvertService = savedJobAdvertService;
    }

    @PostMapping("addtosavedjobadverts")
    public Result addFavorite(@RequestBody SavedJobAdvertsAddDto savedJobAdvertsAddDto) {
        return this.savedJobAdvertService.addSavedJobAdvert(savedJobAdvertsAddDto);
    }

    @GetMapping("/getsavedjobadverts")
    public DataResult<List<SavedJobAdverts>> getFavorites() {
        return this.savedJobAdvertService.getSavedJobAdverts();
    }

    @GetMapping("/getsavedjobadvertsbyjobseekerid")
    public DataResult<List<SavedJobAdverts>> getFavoriteByJobSeekerId(int id) {
        return this.savedJobAdvertService.getSavedJobAdvertsByJobSeekerId(id);
    }

    @DeleteMapping("/deletesavedjobadvertbyid")
    public Result deleteFavoriteById(int id) {
        return this.savedJobAdvertService.deleteSavedJobAdvert(id);
    }

}
