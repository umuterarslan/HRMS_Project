package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
}
