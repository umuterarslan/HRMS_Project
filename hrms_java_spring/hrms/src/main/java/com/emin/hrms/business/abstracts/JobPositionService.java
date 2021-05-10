package com.emin.hrms.business.abstracts;

import com.emin.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    List<JobPosition> getPositions();
}
