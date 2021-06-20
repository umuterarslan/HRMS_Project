package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.CurriculaVitaeService;
import com.emin.hrms.core.services.CloudinaryService;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.CurriculaVitaeDao;
import com.emin.hrms.entities.concretes.CurriculaVitae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CurriculaVitaeManager implements CurriculaVitaeService {

    private CurriculaVitaeDao curriculaVitaeDao;
    private CloudinaryService cloudinaryService;

    @Autowired
    public CurriculaVitaeManager(CurriculaVitaeDao curriculaVitaeDao, CloudinaryService cloudinaryService) {
        this.curriculaVitaeDao = curriculaVitaeDao;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public Result addCv(CurriculaVitae curriculaVitae) {
        this.curriculaVitaeDao.save(curriculaVitae);
        return new SuccessResult("Cv eklendi");
    }

    @Override
    public DataResult<CurriculaVitae> getByJobSeekerId(int id) {
        if (this.curriculaVitaeDao.getByJobSeekerId(id) != null) {
            return new SuccessDataResult<>(this.curriculaVitaeDao.getByJobSeekerId(id),"İş arayan cv'si görüntülendi.");
        } else {
            return new ErrorDataResult<>(null, "İş arayanın bir cv'si bulunmamaktadır!");
        }
    }

    @Override
    public Result uploadPicture(int cvId, MultipartFile file) throws IOException {
        var result = this.cloudinaryService.upload(file);
        var url = result.getData().get("url");
        CurriculaVitae cv = this.curriculaVitaeDao.getOne(cvId);
        cv.setPictureUrl(url.toString());
        this.curriculaVitaeDao.save(cv);
        return new SuccessResult("Başarılı.");
    }


}
