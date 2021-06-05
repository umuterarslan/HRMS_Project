package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.BusinessLife;
import com.emin.hrms.entities.concretes.Education;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessLifeDao extends JpaRepository<BusinessLife,Integer> {

    List<Education> getBusinessLifeEndDateByCurriculaVitaeId(int id, Sort sort);

}
