package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.SystemPersonelService;
import com.emin.hrms.core.dtoConverter.DtoConverterService;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.SystemPersonelDao;
import com.emin.hrms.entities.concretes.SystemPersonel;
import com.emin.hrms.entities.dtos.getDtos.SystemPersonelGetDto;
import com.emin.hrms.entities.dtos.updateDtos.SystemPersonelUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemPersonelManager implements SystemPersonelService {

    private SystemPersonelDao systemPersonelDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public SystemPersonelManager(SystemPersonelDao systemPersonelDao, DtoConverterService dtoConverterService) {
        this.systemPersonelDao = systemPersonelDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<SystemPersonel>> getSystemPersonels() {
        return new SuccessDataResult<>(this.dtoConverterService.dtoConverter(this.systemPersonelDao.findAll(), SystemPersonel.class), "Sistem personelleri listeleme başarılı.");
    }

    @Override
    public Result addSystemPersonel(SystemPersonel systemPersonel) {
        try {
            this.systemPersonelDao.save(systemPersonel);
            return new SuccessResult("Sistem personel ekleme başarılı.");
        } catch (Exception e) {
            if(e.toString().contains("could not execute statement; SQL [n/a]; constraint [null]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement")) {
                return new ErrorDataResult<>(null, "Kullanılan E-Posta adresi zaten kayıtlı!");
            } else {
                return new ErrorDataResult<>(null, "Bir hata oluştu!");
            }
        }
    }

    @Override
    public DataResult<SystemPersonel> getSystemPersonelById(int id)  {
        if (this.systemPersonelDao.getSystemPersonelById(id) != null) {
            return new SuccessDataResult<>((SystemPersonel) this.dtoConverterService.dtoClassConverter(this.systemPersonelDao.getSystemPersonelById(id), SystemPersonel.class), "Sistem personeli bilgileri getirildi.");
        } else {
            return new ErrorDataResult<>(null, "Sistem personeli bilgileri getirme başarısız!");
        }
    }

    @Override
    public Result deleteSystemPersonelById(int id) {
        this.systemPersonelDao.deleteSystemPersonelById(id);
        return new SuccessResult("Silme başarılı.");
    }

//    @Override
//    public Result updateSystemPersonel(int id, String email, String username) {
//        this.systemPersonelDao.updateSystemPersonel(id, email, username);
//        return new SuccessResult("Sistem personel bilgileri güncelleme başarılı.");
//    }

    @Override
    public Result updateSystemPersonel(int id, String email, String username) {
        try {
            this.systemPersonelDao.updateSystemPersonel(id, email, username);
            return new SuccessResult("Sistem personel bilgileri güncelleme başarılı.");
        } catch (Exception e) {
            if(e.toString().contains("could not execute statement; SQL [n/a]; constraint [null]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement")) {
                return new ErrorDataResult<>(null, "Kullanılan E-Posta adresi zaten kayıtlı!");
            } else {
                return new ErrorDataResult<>(null, "Bir hata oluştu!");
            }
        }

    }

}
