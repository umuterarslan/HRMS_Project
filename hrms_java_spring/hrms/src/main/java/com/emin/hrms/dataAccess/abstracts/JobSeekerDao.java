package com.emin.hrms.dataAccess.abstracts;

import com.emin.hrms.entities.concretes.Employer;
import com.emin.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer> {

    JobSeeker getJobSeekerById(int id);

    @Transactional
    void deleteJobSeekerById(int id);

}
