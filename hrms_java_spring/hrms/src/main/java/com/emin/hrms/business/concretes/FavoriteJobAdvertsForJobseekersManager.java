package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.FavoriteJobAdvertsForJobseekersService;
import com.emin.hrms.core.dtoConverter.DtoConverterService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.core.utilities.results.SuccessDataResult;
import com.emin.hrms.core.utilities.results.SuccessResult;
import com.emin.hrms.dataAccess.abstracts.FavoriteJobAdvertsForJobseekersDao;
import com.emin.hrms.entities.concretes.FavoriteJobAdvertsForJobseekers;
import com.emin.hrms.entities.dtos.addDtos.FavoriteJobAdvertsForJobseekersAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteJobAdvertsForJobseekersManager implements FavoriteJobAdvertsForJobseekersService {

    private FavoriteJobAdvertsForJobseekersDao favoriteJobAdvertsForJobseekersDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public FavoriteJobAdvertsForJobseekersManager(FavoriteJobAdvertsForJobseekersDao favoriteJobAdvertsForJobseekersDao, DtoConverterService dtoConverterService) {
        this.favoriteJobAdvertsForJobseekersDao = favoriteJobAdvertsForJobseekersDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addFavorite(FavoriteJobAdvertsForJobseekersAddDto favoriteJobAdvertsForJobseekersAddDto) {
        this.favoriteJobAdvertsForJobseekersDao.save((FavoriteJobAdvertsForJobseekers) this.dtoConverterService.dtoClassConverter(favoriteJobAdvertsForJobseekersAddDto, FavoriteJobAdvertsForJobseekers.class));
        return new SuccessResult("Favorilere ekleme başarılı.");
    }

    @Override
    public DataResult<List<FavoriteJobAdvertsForJobseekers>> getFavorites() {
        return new SuccessDataResult(this.favoriteJobAdvertsForJobseekersDao.findAll(),"Favori iş işlanları listeleme başarılı.");
    }

    @Override
    public DataResult<List<FavoriteJobAdvertsForJobseekers>> getFavoritesByJobSeekerId(int id) {
        return new SuccessDataResult<>(this.favoriteJobAdvertsForJobseekersDao.getFavoriteJobAdvertsForJobseekersByJobSeekerId(id));
    }

    @Override
    public Result deleteFavorite(int id) {
        this.favoriteJobAdvertsForJobseekersDao.deleteById(id);
        return new SuccessResult("Favori silme başarılı.");
    }


}
