package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDao extends JpaRepository<School, Integer> {
}
