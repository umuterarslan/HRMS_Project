package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.Education;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationDao extends JpaRepository<Education, Integer> {

    List<Education> getEducationEndDateByCurriculaVitaeId(int id, Sort sort);

}
