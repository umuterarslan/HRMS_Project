package com.emin.hrms.dataAccess.abstracts;

import com.cloudinary.utils.ObjectUtils;
import com.emin.hrms.entities.concretes.JobAdvert;
import com.emin.hrms.entities.concretes.SystemPersonel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.cloudinary.*;

import javax.transaction.Transactional;
import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap());

    List<JobAdvert> getAllByIsActiveTrue();

    List<JobAdvert> getJobAdvertByIsActiveTrueAndEmployer_CompanyName(String companyName);

    List<JobAdvert> getJobAdvertByIsActiveTrueAndIsConfirmedTrue(Sort sort);

    List<JobAdvert> getAllByIsActiveTrue(Sort sort);

    @Transactional
    @Modifying
    @Query("Update JobAdvert set isActive = :state where id =:jobAdvertId")
    void changeActiveJobAdvert(int jobAdvertId, boolean state);

    @Transactional
    @Modifying
    @Query("Update JobAdvert set isConfirmed = :state where id =:jobAdvertId")
    void changeConfirmedJobAdvert(int jobAdvertId, boolean state);

    JobAdvert getJobAdvertById(int id);

    @Transactional
    void deleteJobAdvertById(int id);

}

