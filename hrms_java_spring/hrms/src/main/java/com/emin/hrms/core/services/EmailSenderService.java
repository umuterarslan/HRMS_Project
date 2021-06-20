package com.emin.hrms.core.services;

import com.emin.hrms.entities.concretes.User;

public interface EmailSenderService {

    String emailSender(User user);

}
