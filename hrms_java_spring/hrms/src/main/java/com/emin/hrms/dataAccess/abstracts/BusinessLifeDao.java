package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.BusinessLife;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface BusinessLifeDao extends JpaRepository<BusinessLife, Integer> {

    List<BusinessLife> getBusinessLifeEndDateByCurriculaVitaeId(int id, Sort sort);

    @Transactional
    void deleteBusinessLifeById(int id);

}
