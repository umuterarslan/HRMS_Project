package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<Language, Integer> {
}
