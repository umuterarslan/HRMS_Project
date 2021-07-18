package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.entities.concretes.JobSeekerLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage, Integer> {

    @Transactional
    void deleteJobSeekerLanguageById(int id);

}
