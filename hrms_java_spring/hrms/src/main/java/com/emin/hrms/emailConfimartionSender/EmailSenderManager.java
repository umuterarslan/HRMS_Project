package com.emin.hrms.emailConfimartionSender;

import com.emin.hrms.entities.concretes.User;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderManager {

    public String emailSender(User user) {
        return user.getEmail() + " adresinden üyeliğinizi onaylayın.";
    }

}
