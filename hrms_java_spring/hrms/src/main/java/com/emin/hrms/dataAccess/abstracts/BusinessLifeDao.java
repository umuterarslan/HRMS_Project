package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.BusinessLife;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessLifeDao extends JpaRepository<BusinessLife,Integer> {
}
