package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.JobSeekerLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage, Integer> {
}
