package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.FavoriteJobAdvertsForJobseekers;
import com.emin.hrms.entities.dtos.addDtos.FavoriteJobAdvertsForJobseekersAddDto;

import java.util.List;

public interface FavoriteJobAdvertsForJobseekersService {

    Result addFavorite(FavoriteJobAdvertsForJobseekersAddDto favoriteJobAdvertsForJobseekersAddDto);

    DataResult<List<FavoriteJobAdvertsForJobseekers>> getFavorites();

    DataResult<List<FavoriteJobAdvertsForJobseekers>> getFavoritesByJobSeekerId(int id);

    Result deleteFavorite(int id);

}
