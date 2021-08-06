package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.JobAdvert;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

    List<JobAdvert> getAllByIsActiveTrue();

    List<JobAdvert> getJobAdvertByIsActiveTrueAndEmployer_CompanyName(String companyName);

    List<JobAdvert> getJobAdvertByIsActiveTrueAndIsConfirmedTrue(Pageable pageable);

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

    @Query("select count (ja) from JobAdvert ja where ja.isConfirmed=true and ja.isActive=true and ja.employer.id =:id")
    long countActiveAndConfirmedByEmployerId(int id);

    @Query("select count (ja) from JobAdvert ja where ja.isConfirmed=true and ja.isActive=true")
    long countAllActiveAndConfirmed();

    List<JobAdvert> getJobAdvertByIsActiveTrueAndIsConfirmedTrueAndEmployer_Id(int id);

}

