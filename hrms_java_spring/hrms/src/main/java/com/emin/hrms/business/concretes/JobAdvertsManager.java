package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.JobAdvertService;
import com.emin.hrms.core.utilities.IsFull;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.JobAdvertsDao;
import com.emin.hrms.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertsManager implements JobAdvertService {

    private final JobAdvertsDao jobAdvertsDao;

    @Autowired
    public JobAdvertsManager(JobAdvertsDao jobAdvertsDao) {
        this.jobAdvertsDao = jobAdvertsDao;
    }

    @Override
    public DataResult<List<JobAdvert>> getJobAdverts() {
        return new SuccessDataResult<>(this.jobAdvertsDao.findAll(), "İş ilanları listelendi.");
    }

    @Override
    public Result addJobAdvert(JobAdvert jobAdvert) {
        this.jobAdvertsDao.save(jobAdvert);
        return new SuccessResult("İş ilanı eklendi");
    }

    @Override
    public DataResult<List<JobAdvert>> getActiveJobAdverts() {
        if (IsFull.listController(this.jobAdvertsDao.findAllByIsActiveTrue())) {
            return new SuccessDataResult<>(this.jobAdvertsDao.findAllByIsActiveTrue(), "Aktif iş ilanları istelendi.");
        } else {
            return new SuccessDataResult<>(null, "Listelenecek aktif iş ilanı bulunamadı.");
        }
    }

    @Override
    public DataResult<List<JobAdvert>> findAllByIsActiveTrue() {
        Sort sort = Sort.by(Sort.Direction.DESC, "releaseDate");
        if (IsFull.listController(this.jobAdvertsDao.findAllByIsActiveTrue())) {
            return new SuccessDataResult<>(this.jobAdvertsDao.findAllByIsActiveTrue(sort), "Aktif iş ilanları yeniden eskiye sıralama ile listelendi.");
        } else {
            return new SuccessDataResult<>(null, "Sıralanacak aktif iş ilanı bulunamadı!");
        }
    }

    @Override
    public DataResult<List<JobAdvert>> getActiveJobAdvertsForEmployer(String companyName) {
        if (IsFull.listController(this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndEmployer_CompanyName(companyName))) {
            return new SuccessDataResult<>(this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndEmployer_CompanyName(companyName), "Şirkete ait aktif iş ilanları listelendi.");
        } else {
            return new SuccessDataResult<>(null, "Şirkete ait listelenecek aktif iş ilanı bulunamadı!");
        }
    }

    @Override
    public Result setPasiveJobAdvert(int jobAdvertId) {
        this.jobAdvertsDao.setPasiveJobAdvert(jobAdvertId);
        return new SuccessResult("İş ilanı pasif olarak güncellendi.");
    }
}
