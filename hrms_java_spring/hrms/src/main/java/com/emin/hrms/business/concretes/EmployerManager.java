package com.emin.hrms.business.concretes;

import com.emin.hrms.business.abstracts.EmployerService;
import com.emin.hrms.core.services.CloudinaryService;
import com.emin.hrms.core.services.EmailSenderService;
import com.emin.hrms.core.utilities.EmailValidator;
import com.emin.hrms.core.utilities.results.*;
import com.emin.hrms.dataAccess.abstracts.EmployerDao;
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
    private final EmailSenderService emailSenderService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, CloudinaryService cloudinaryService, EmailSenderService emailSenderService) {
        this.employerDao = employerDao;
        this.cloudinaryService = cloudinaryService;
        this.emailSenderService = emailSenderService;
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
            } else {
                this.employerDao.save(employer);
                return new SuccessResult("İş arayan olarak kayıt olundu! " + emailSenderService.emailSender(employer.getEmail()));
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
    public Result updateEmployer(int id, String companyName, String email, String phoneNumber, String website) {
        String[] employerWebsite = website.split("\\.", 2);
        String splittedWebsite = employerWebsite[1];
        String[] employerEmail = email.split("@");
        String employerDomain = employerEmail[1];
        try {
            if (!EmailValidator.emailFormatController(email)) {
                return new ErrorResult("Mail formata uygun değil!");
            } else if (!employerDomain.equals(splittedWebsite)) {
                return new ErrorResult("Şirket gerçekliği doğrulanamadı!");
            } else {
                this.employerDao.updateEmployer(id, companyName, email, phoneNumber, website);
                return new SuccessResult("İş arayan bilgileri güncellemesi başarılı. " + emailSenderService.emailSender(email));
            }
        } catch (Exception e) {
            return new ErrorResult(e.toString());
        }
    }

//    @Override
//    public Result updateEmployer(EmployerUpdateDto employerUpdateDto) {
//        String[] employerWebsite = employerUpdateDto.getWebsite().split("\\.", 2);
//        String website = employerWebsite[1];
//        String[] employerEmail = employerUpdateDto.getEmail().split("@");
//        String employerDomain = employerEmail[1];
//        try {
//            if (!EmailValidator.emailFormatController(employerUpdateDto.getEmail())) {
//                return new ErrorResult("Mail formata uygun değil!");
//            } else if (!employerDomain.equals(website)) {
//                return new ErrorResult("Şirket gerçekliği doğrulanamadı!");
//            } else {
//                this.employerDao.save((Employer) this.dtoConverterService.dtoClassConverter(employerUpdateDto, Employer.class));
//                return new SuccessResult("İş arayan bilgileri güncellemesi başarılı. " + emailSenderService.emailSender(this.employerDao.save((Employer) this.dtoConverterService.dtoClassConverter(employerUpdateDto, Employer.class))));
//            }
//        } catch (Exception e) {
//            return new ErrorResult(e.toString());
//        }
//    }

    @Override
    public DataResult<Employer> getEmployerById(int id) {
        if (this.employerDao.getEmployerById(id) != null) {
            return new SuccessDataResult<>(this.employerDao.getEmployerById(id), "iş veren bilgileri getirildi");
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

    @Override
    public Result setUpdateRequest(int id, Boolean bool) {
        this.employerDao.setUpdateRequest(id, bool);
        return new SuccessResult("İş verene ait güncelleme durumu bilgisi değiştirildi.");
    }

}
