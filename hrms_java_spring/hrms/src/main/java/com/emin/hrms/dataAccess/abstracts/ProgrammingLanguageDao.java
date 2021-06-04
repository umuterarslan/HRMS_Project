package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingLanguageDao extends JpaRepository<ProgrammingLanguage, Integer> {
}
