package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.entities.concretes.FavoriteJobAdvertsForJobseekers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteJobAdvertsForJobseekersDao extends JpaRepository<FavoriteJobAdvertsForJobseekers, Integer> {

    List<FavoriteJobAdvertsForJobseekers> getFavoriteJobAdvertsForJobseekersByJobSeekerId(int id);

}
