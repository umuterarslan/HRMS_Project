package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDao extends JpaRepository<Education, Integer> {
}
