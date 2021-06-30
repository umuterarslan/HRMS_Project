package com.emin.hrms.api.controller;

import com.emin.hrms.business.abstracts.FavoriteJobAdvertsForJobseekersService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.FavoriteJobAdvertsForJobseekers;
import com.emin.hrms.entities.dtos.addDtos.FavoriteJobAdvertsForJobseekersAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoritejobadvertsforjobseekers")
@CrossOrigin
public class FavoriteJobAdvertsForJobseekersController {

    private FavoriteJobAdvertsForJobseekersService favoriteJobAdvertsForJobseekersService;

    @Autowired
    public FavoriteJobAdvertsForJobseekersController(FavoriteJobAdvertsForJobseekersService favoriteJobAdvertsForJobseekersService) {
        this.favoriteJobAdvertsForJobseekersService = favoriteJobAdvertsForJobseekersService;
    }

    @PostMapping("addfavorite")
    public Result addFavorite(@RequestBody FavoriteJobAdvertsForJobseekersAddDto favoriteJobAdvertsForJobseekersAddDto) {
        return this.favoriteJobAdvertsForJobseekersService.addFavorite(favoriteJobAdvertsForJobseekersAddDto);
    }

    @GetMapping("/getfavorites")
    public DataResult<List<FavoriteJobAdvertsForJobseekers>> getFavorites() {
        return this.favoriteJobAdvertsForJobseekersService.getFavorites();
    }

    @GetMapping("/getfavoritebyjobseekerid")
    public DataResult<List<FavoriteJobAdvertsForJobseekers>> getFavoriteByJobSeekerId(int id) {
        return this.favoriteJobAdvertsForJobseekersService.getFavoritesByJobSeekerId(id);
    }

    @DeleteMapping("/deletefavoritebyid")
    public Result deleteFavoriteById(int id) {
        return this.favoriteJobAdvertsForJobseekersService.deleteFavorite(id);
    }

}
