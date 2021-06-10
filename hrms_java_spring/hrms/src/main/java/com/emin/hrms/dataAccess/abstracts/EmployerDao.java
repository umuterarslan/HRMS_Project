package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

    Employer getEmployerById(int id);

    @Transactional
    void deleteEmployerById(int id);

}
