package com.emin.hrms.business.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.SavedJobAdverts;
import com.emin.hrms.entities.dtos.addDtos.SavedJobAdvertsAddDto;

import java.util.List;

public interface SavedJobAdvertService {

    Result addSavedJobAdvert(SavedJobAdvertsAddDto favoriteJobAdvertsForJobseekersAddDto);

    DataResult<List<SavedJobAdverts>> getSavedJobAdverts();

    DataResult<List<SavedJobAdverts>> getSavedJobAdvertsByJobSeekerId(int id);

    Result deleteSavedJobAdvert(int id);

}
