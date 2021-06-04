package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer> {
}
