package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department, Integer> {
}
