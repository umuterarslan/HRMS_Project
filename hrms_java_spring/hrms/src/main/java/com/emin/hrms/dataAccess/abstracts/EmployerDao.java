package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

    Employer getEmployerById(int id);

    @Transactional
    void deleteEmployerById(int id);

    @Transactional
    @Modifying
    @Query("Update Employer emp set emp.companyName = :companyName, emp.email = :email, emp.phoneNumber = :phoneNumber, emp.website = :website where emp.id = :id")
    void updateEmployer(int id, String companyName, String email, String phoneNumber, String website);

    @Transactional
    @Modifying
    @Query("Update Employer emp set emp.reqFlag = :bool where emp.id = :id")
    void setUpdateRequest(int id, Boolean bool);

}
