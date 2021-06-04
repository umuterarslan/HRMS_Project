package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.CurriculaVitae;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculaVitaeDao extends JpaRepository<CurriculaVitae, Integer> {

    CurriculaVitae getByJobSeekerId(int id);

}