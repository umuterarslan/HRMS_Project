package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.JobAdvertService;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.JobAdvertsDao;
import com.emin.hrms.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertsManager implements JobAdvertService {

    private JobAdvertsDao jobAdvertsDao;

    @Autowired
    public JobAdvertsManager(JobAdvertsDao jobAdvertsDao) {
        this.jobAdvertsDao = jobAdvertsDao;
    }

    @Override
    public DataResult<List<JobAdvert>> getJobAdverts() {
        return new SuccessDataResult<>(this.jobAdvertsDao.findAll(), "İş ilanları listelendi.");
    }

    @Override
    public Result addJobAdvert(JobAdvert jobAdvert) { this.jobAdvertsDao.save(jobAdvert);
        return new SuccessResult("İş ilanı eklendi");
    }

    @Override
    public DataResult<List<JobAdvert>> getActiveJobAdverts() {
            return new SuccessDataResult<>(this.jobAdvertsDao.findAllByIsActiveTrue(), "Aktif iş ilanları listelemesi başarılı.");
    }

//    @Override
//    public DataResult<List<JobAdvert>> findAllByIsActiveTrue() {
//        Sort sort = Sort.by(Sort.Direction.DESC,"releaseDate");
//        return new SuccessDataResult<>(this.jobAdvertsDao.findAllByIsActiveTrue(sort), "Aktif iş ilanları artan sıralama ile listelendi.");
//    }

    @Override
    public DataResult<List<JobAdvert>> findAllByIsActiveTrue() {
        Sort sort = Sort.by(Sort.Direction.DESC, "releaseDate");
        if (this.jobAdvertsDao.findAllByIsActiveTrue(sort).stream().count() > 0) { return new SuccessDataResult<>(this.jobAdvertsDao.findAllByIsActiveTrue(sort),
           "Aktif iş ilanları artan sıralama ile listelendi.");
        }
        return new SuccessDataResult<>(this.jobAdvertsDao.findAllByIsActiveTrue(sort), "Sıralanacak aktif iş ilanı bulunamadı.");
    }

    @Override
    public DataResult<List<JobAdvert>> getActiveJobAdvertsForEmployer(String companyName) {
        return new SuccessDataResult<>(this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndEmployer_CompanyName(companyName), "İlgili şirkete ait iş ilanları listelendi.");
    }

    @Override
    public Result deactiveJobAdvert(int jobAdvertId) {
        this.jobAdvertsDao.setPasiveJobAdvert(jobAdvertId);
        return new SuccessResult("İş ilanı pasif olarak güncellendi.");
    }
}
