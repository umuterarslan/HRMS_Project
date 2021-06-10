package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.SystemPersonelService;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.SystemPersonelDao;
import com.emin.hrms.entities.concretes.JobSeeker;
import com.emin.hrms.entities.concretes.SystemPersonel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemPersonelManager implements SystemPersonelService {

    private SystemPersonelDao systemPersonelDao;

    @Autowired
    public SystemPersonelManager(SystemPersonelDao systemPersonelDao) {
        this.systemPersonelDao = systemPersonelDao;
    }

    @Override
    public DataResult<List<SystemPersonel>> getSystemPersonels() {
        return new SuccessDataResult<>(this.systemPersonelDao.findAll(),"Sistem personelleri listeleme başarılı.");
    }

    @Override
    public Result addSystemPersonel(SystemPersonel systemPersonel) {
        this.systemPersonelDao.save(systemPersonel);
        return new SuccessResult("Sistem personel ekleme başarılı.");
    }

    @Override
    public DataResult<SystemPersonel> getSystemPersonelById(int id) {
        if (this.systemPersonelDao.getSystemPersonelById(id) != null) {
            return new SuccessDataResult<>(this.systemPersonelDao.getSystemPersonelById(id),"Sistem personeli bilgileri getirildi");
        } else {
            return new ErrorDataResult<>(null, "Sistem personeli bilgileri getirme başarısız!");
        }
    }

    @Override
    public Result deleteSystemPersonelById(int id) {
        this.systemPersonelDao.deleteSystemPersonelById(id);
        return new SuccessResult("Silme başarılı.");
    }

}
