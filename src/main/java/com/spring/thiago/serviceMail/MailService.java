package com.spring.thiago.serviceMail;

import com.spring.thiago.model.Mail;
import com.spring.thiago.model.User;

import java.util.List;

public interface MailService {
    List<Mail> findALlMail();
    Mail findByIdMail(long id);
    Mail save(Mail mail);
    void deleteMail(long id);

    List<Mail> findAllId(int id);

    List<User> findALl();
}
