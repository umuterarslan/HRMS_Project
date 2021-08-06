package com.emin.hrms.core.adapters;

import com.emin.hrms.core.services.EmailSenderService;
import com.emin.hrms.emailConfimartionSender.EmailSenderManager;
import com.emin.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderManagerAdapter implements EmailSenderService {

    private EmailSenderManager emailSenderManager;

    @Autowired
    public EmailSenderManagerAdapter(EmailSenderManager emailSenderManager) {
        this.emailSenderManager = emailSenderManager;
    }

    @Override
    public String emailSender(String email) {
        return this.emailSenderManager.emailSender(email);
    }

}
