package com.emin.hrms.dataAccess.abstracts;

import com.cloudinary.utils.ObjectUtils;
import com.emin.hrms.entities.concretes.JobAdvert;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.cloudinary.*;

import javax.transaction.Transactional;
import java.util.List;

public interface JobAdvertsDao extends JpaRepository<JobAdvert, Integer> {

    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap());

    List<JobAdvert> findAllByIsActiveTrue();

    List<JobAdvert> getJobAdvertByIsActiveTrueAndEmployer_CompanyName(String companyName);

    List<JobAdvert> findAllByIsActiveTrue(Sort sort);

    @Transactional
    @Modifying
    @Query("Update JobAdvert set isActive = false where id =:jobAdvertId")
    void setPasiveJobAdvert(int jobAdvertId);

}

