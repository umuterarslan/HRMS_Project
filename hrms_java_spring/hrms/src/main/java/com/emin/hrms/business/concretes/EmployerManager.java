package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.EmployerService;
import com.emin.hrms.core.utilities.EmailValidator;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.EmployerDao;
import com.emin.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private final EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getEmployers() {
        return new SuccessDataResult<>(employerDao.findAll(), "İş verenler listelendi.");
    }

    @Override
    public Result addEmployer(Employer employer) {
        String[] employerWebsite = employer.getWebsite().split("\\.", 2);
        String website = employerWebsite[1];
        String[] employerEmail = employer.getEmail().split("@");
        String employerDomain = employerEmail[1];
        try {
            if (!EmailValidator.emailFormatController(employer.getEmail())) {
                return new ErrorResult("Mail formata uygun değil!");
            } else if (!employerDomain.equals(website)) {
                return new ErrorResult("Şirket gerçekliği doğrulanamadı!");
            } else if (!employer.getPassword().equals(employer.getConfirmPassword())) {
                return new ErrorResult("Girilen parolalar aynı olmalıdır!");
            } else {
                this.employerDao.save(employer);
                return new SuccessResult("İş arayan olarak kayıt olundu! Eposta adresinizden üyeliğinizi onaylayınız.");
            }
        } catch (Exception e) {
            if (e.getMessage()
                    .equals("could not execute statement; SQL [n/a]; constraint [uc_users_email]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement")) {
                return new ErrorResult("Kayıt olmaya çalıştığınız eposta sistemde zaten mevcut!");
            } else {
                return new ErrorResult("Kayıt olmaya çalıştığınız şirket sistemde zaten mevcut!");
            }
        }
    }
}
