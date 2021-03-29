package com.spring.thiago.serviceMail;

import com.spring.thiago.model.Mail;
import com.spring.thiago.model.User;
import com.spring.thiago.repository.MailRepository;
import com.spring.thiago.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceMailimpl implements MailService {
    @Autowired
    MailRepository repo;
    UserRepository repoU;

    @Override
    public List<Mail> findALlMail() {
        return repo.findAll();
    }


    @Override
    public Mail findByIdMail(long id) {
        return (Mail) repo.findById(id).get();
    }

    @Override
    public Mail save(Mail mail) {
        return (Mail) repo.save(mail);
    }

    @Override
    public void deleteMail(long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Mail> findAllId(int id) {
        return repo.findAllId(id);
    }

    @Override
    public List<User> findALl() {
        return repoU.findAll();
    }


}
