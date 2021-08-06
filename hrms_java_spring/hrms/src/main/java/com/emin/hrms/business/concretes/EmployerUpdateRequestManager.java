package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.EmployerUpdateRequestService;
import com.emin.hrms.core.dtoConverter.DtoConverterService;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.EmployerUpdateRequestDao;
import com.emin.hrms.entities.concretes.EmployerUpdateRequest;
import com.emin.hrms.entities.dtos.addDtos.EmployerUpdateRequestAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerUpdateRequestManager implements EmployerUpdateRequestService {

    private EmployerUpdateRequestDao employerUpdateRequestDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public EmployerUpdateRequestManager(EmployerUpdateRequestDao employerUpdateRequestDao, DtoConverterService dtoConverterService) {
        this.employerUpdateRequestDao = employerUpdateRequestDao;
        this.dtoConverterService = dtoConverterService;
    }


    @Override
    public Result addEmployerUpdateRequest(EmployerUpdateRequestAddDto employerUpdateRequestAddDto) {
        try {
            this.employerUpdateRequestDao.save((EmployerUpdateRequest)
                    this.dtoConverterService.dtoClassConverter(employerUpdateRequestAddDto, EmployerUpdateRequest.class));
            return new SuccessResult("Güncelleme talebi gönderildi.");
        } catch (Exception e) {
            if(e.toString().contains("could not execute statement; SQL [n/a]; constraint [null]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement")) {
                return new ErrorResult("Sadece bir tane güncelleme isteği gönderilebilir!");
            } else {
                return new ErrorResult("Bir hata oluştu!");
            }
        }
    }

    @Override
    public DataResult<List<EmployerUpdateRequest>> getAllEmployerUpdateRequest() {
        return new SuccessDataResult<>(this.employerUpdateRequestDao.findAll(),"Şirket güncelleme istekleri getirildi.");
    }

    @Override
    public DataResult<EmployerUpdateRequest> getEmployerUpdateRequestByEmployerId(int id) {
        if (this.employerUpdateRequestDao.getEmployerChangeRequestByEmployer_Id(id) != null) {
            return new SuccessDataResult<>(this.employerUpdateRequestDao.getEmployerChangeRequestByEmployer_Id(id), "İş verene ait güncelleme verileri getirildi.");
        } else {
            return new ErrorDataResult<>(null, "Getirilecek veri bulunamadı!");
        }
    }

    @Override
    public Result deleteEmployerUpdateRequestById(int id) {
        this.employerUpdateRequestDao.deleteEmployerUpdateRequestById(id);
        return new SuccessResult("Güncelleme isteği silindi.");
    }
}
