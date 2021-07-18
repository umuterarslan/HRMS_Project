package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface TechnologyDao extends JpaRepository<Technology, Integer> {

    @Transactional
    void deleteTechnologyById(int id);

}
