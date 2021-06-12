package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.EmployerService;
import com.emin.hrms.core.helpers.CloudinaryService;
import com.emin.hrms.core.utilities.EmailValidator;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.EmployerDao;
import com.emin.hrms.entities.concretes.CurriculaVitae;
import com.emin.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private final EmployerDao employerDao;
    private CloudinaryService cloudinaryService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, CloudinaryService cloudinaryService) {
        this.employerDao = employerDao;
        this.cloudinaryService = cloudinaryService;
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

    @Override
    public DataResult<Employer> getEmployerById(int id) {
        if (this.employerDao.getEmployerById(id) != null) {
            return new SuccessDataResult<>(this.employerDao.getEmployerById(id),"iş veren bilgileri getirildi");
        } else {
            return new ErrorDataResult<>(null, "İş veren bilgileri getirme başarısız!");
        }
    }

    @Override
    public Result deleteEmployerById(int id) {
        this.employerDao.deleteEmployerById(id);
        return new SuccessResult("Silme başarılı.");
    }

    @Override
    public Result uploadPicture(int employerId, MultipartFile file) throws IOException {
        var result = this.cloudinaryService.upload(file);
        var url = result.getData().get("url");
        Employer employer = this.employerDao.getOne(employerId);
        employer.setPictureUrl(url.toString());
        this.employerDao.save(employer);
        return new SuccessResult("Başarılı.");
    }


}
