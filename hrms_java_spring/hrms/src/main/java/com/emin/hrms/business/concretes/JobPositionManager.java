package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.JobPositionService;
import com.emin.hrms.core.utilities.IsInputFull;
import com.emin.hrms.core.utilities.results.*;
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
    public DataResult<List<JobPosition>> getPositions() {
        return new SuccessDataResult<>(this.jobPositionDao.findAll(),"İş ozisyonaları listelendi.");
    }

    @Override
    public Result addJobPosition(JobPosition jobPosition) {
        try {
            if (!IsInputFull.inputController(jobPosition.getJobTitle())) {
                return new ErrorResult("İş pozisyonu adı boş bırakılamaz!");
            } else {
                this.jobPositionDao.save(jobPosition);
                return new SuccessResult("İş pozisyonu eklendi: " + jobPosition.getJobTitle());
            }
        }catch (Exception e) {
            return new ErrorResult("İş pozisyonları eşsiz olmalıdır.");
        }
    }
}