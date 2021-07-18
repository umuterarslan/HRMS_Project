package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.CurriculaVitae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CurriculaVitaeDao extends JpaRepository<CurriculaVitae, Integer> {

    CurriculaVitae getByJobSeekerId(int id);

    @Transactional
    @Modifying
    @Query("Update CurriculaVitae cv set cv.coverLetter = :coverLetter where cv.id = :id")
    void updateCvCoverLetter(int id, String coverLetter);

}