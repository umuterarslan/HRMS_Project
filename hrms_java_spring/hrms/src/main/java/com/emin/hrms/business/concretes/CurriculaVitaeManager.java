package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.CurriculaVitaeService;
import com.emin.hrms.core.utilities.results.Result;
import com.emin.hrms.core.utilities.results.SuccessResult;
import com.emin.hrms.dataAccess.abstracts.CurriculaVitaeDao;
import com.emin.hrms.entities.concretes.CurriculaVitae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurriculaVitaeManager implements CurriculaVitaeService {

    private CurriculaVitaeDao curriculaVitaeDao;

    @Autowired
    public CurriculaVitaeManager(CurriculaVitaeDao curriculaVitaeDao) {
        this.curriculaVitaeDao = curriculaVitaeDao;
    }

    @Override
    public Result addCv(CurriculaVitae curriculaVitae) {
        this.curriculaVitaeDao.save(curriculaVitae);
        return new SuccessResult("Cv eklendi");
    }
}
