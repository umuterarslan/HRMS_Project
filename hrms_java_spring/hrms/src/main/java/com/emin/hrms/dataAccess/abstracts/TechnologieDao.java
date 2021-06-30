package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologieDao extends JpaRepository<Technology, Integer> {
}
