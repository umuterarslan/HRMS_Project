package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.SavedJobAdverts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavedJobAdvertsDao extends JpaRepository<SavedJobAdverts, Integer> {

    List<SavedJobAdverts> getSavedJobAdvertsByJobSeekerId(int id);

}
