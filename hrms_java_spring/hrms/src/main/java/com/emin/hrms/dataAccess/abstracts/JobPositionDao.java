package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
}
