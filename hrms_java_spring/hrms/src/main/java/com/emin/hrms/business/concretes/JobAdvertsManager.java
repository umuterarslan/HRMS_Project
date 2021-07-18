package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.JobAdvertService;
import com.emin.hrms.core.dtoConverter.DtoConverterService;
import com.emin.hrms.core.utilities.IsFull;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.JobAdvertDao;
import com.emin.hrms.entities.concretes.JobAdvert;
import com.emin.hrms.entities.dtos.addDtos.JobAdvertAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertsManager implements JobAdvertService {

    private final JobAdvertDao jobAdvertsDao;
    private DtoConverterService dtoConverterService;


    @Autowired
    public JobAdvertsManager(JobAdvertDao jobAdvertsDao, DtoConverterService dtoConverterService) {
        this.jobAdvertsDao = jobAdvertsDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<JobAdvert>> getJobAdverts() {
        return new SuccessDataResult<>(this.jobAdvertsDao.findAll(), "İş ilanları listelendi.");
    }

    @Override
    public Result addJobAdvert(JobAdvertAddDto jobAdvertAddDto) {
        this.jobAdvertsDao.save((JobAdvert) this.dtoConverterService.dtoClassConverter(jobAdvertAddDto, JobAdvert.class));
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
    public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueAndPageableDesc(int pageNo,int pageSize) {
        Sort sort;
        sort = Sort.by(Sort.Direction.DESC, "releaseDate");

        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        if (this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable).size() > 0) {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable),
                    "İş ilanları en yeni olarak sıralandı.");
        }

        return new ErrorDataResult<>(
                this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable),
                "Sıralanacak iş ilanı bulunamadı.");
    }

    @Override
    public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueAndPageableAsc(int pageNo, int pageSize) {
        Sort sort;
        sort = Sort.by(Sort.Direction.ASC, "releaseDate");

        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        if (this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable).size() > 0) {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable),
                    "İş ilanları en eski olarak sıralandı.");
        }

        return new ErrorDataResult<>(
                this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable),
                "Sıralanacak iş ilanı bulunamadı.");
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
