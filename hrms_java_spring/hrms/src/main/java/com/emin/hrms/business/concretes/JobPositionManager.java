package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.JobPositionService;
import com.emin.hrms.dataAccess.abstracts.JobPositionDao;
import com.emin.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public List<JobPosition> getPositions() {
        return this.jobPositionDao.findAll();
    }
}