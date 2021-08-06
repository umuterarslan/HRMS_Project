package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.EmployerUpdateRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface EmployerUpdateRequestDao extends JpaRepository<EmployerUpdateRequest, Integer> {

    EmployerUpdateRequest getEmployerChangeRequestByEmployer_Id(int id);

    @Transactional
    void deleteEmployerUpdateRequestById(int id);

}
