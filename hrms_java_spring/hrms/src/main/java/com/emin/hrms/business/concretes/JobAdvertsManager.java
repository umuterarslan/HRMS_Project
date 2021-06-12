package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.JobAdvertService;
import com.emin.hrms.core.utilities.IsFull;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.JobAdvertDao;
import com.emin.hrms.entities.concretes.JobAdvert;
import com.emin.hrms.entities.concretes.SystemPersonel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertsManager implements JobAdvertService {

    private final JobAdvertDao jobAdvertsDao;

    @Autowired
    public JobAdvertsManager(JobAdvertDao jobAdvertsDao) {
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
        if (IsFull.listController(this.jobAdvertsDao.getAllByIsActiveTrue())) {
            return new SuccessDataResult<>(this.jobAdvertsDao.getAllByIsActiveTrue(), "Aktif iş ilanları istelendi.");
        } else {
            return new SuccessDataResult<>(null, "Listelenecek aktif iş ilanı bulunamadı.");
        }
    }

    @Override
    public DataResult<List<JobAdvert>> getAllByIsActiveTrue(boolean isDesc) {
        Sort sort;
        if (isDesc) {
            sort = Sort.by(Sort.Direction.DESC, "releaseDate");
        } else {
            sort = Sort.by(Sort.Direction.ASC, "releaseDate");
        }
        if (IsFull.listController(this.jobAdvertsDao.getAllByIsActiveTrue())) {
            return new SuccessDataResult<>(this.jobAdvertsDao.getAllByIsActiveTrue(sort), "Aktif iş ilanları yeniden eskiye sıralama ile listelendi.");
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
    public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrue(boolean isDesc) {
        Sort sort;
        if (isDesc){
            sort = Sort.by(Sort.Direction.DESC, "releaseDate");
        } else {
            sort = Sort.by(Sort.Direction.ASC, "releaseDate");
        }
        return new SuccessDataResult<>(this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(sort));
    }

    @Override
    public Result changeActiveJobAdvert(int jobAdvertId, boolean state) {
        this.jobAdvertsDao.changeActiveJobAdvert(jobAdvertId, state);
        return new SuccessResult("İş ilanı aktifliği değiştirme başarılı.");
    }

    @Override
    public Result changeConfirmedJobAdvert(int jobAdvertId, boolean state) {
        this.jobAdvertsDao.changeConfirmedJobAdvert(jobAdvertId, state);
        return new SuccessResult("İş ilanı onayı değiştirme başarılı.");
    }

    @Override
    public DataResult<JobAdvert> getJobAdvertById(int id) {
        if (this.jobAdvertsDao.getJobAdvertById(id) != null) {
            return new SuccessDataResult<>(this.jobAdvertsDao.getJobAdvertById(id),"İş ilanı bilgileri getirildi");
        } else {
            return new ErrorDataResult<>(null, "İş ilanı bilgileri getirme başarısız!");
        }
    }

    @Override
    public Result deleteJobAdvertById(int id) {
        this.jobAdvertsDao.deleteJobAdvertById(id);
        return new SuccessResult("Silme başarılı.");
    }

}
