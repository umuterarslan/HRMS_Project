package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.Technologie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologieDao extends JpaRepository<Technologie, Integer> {
}
