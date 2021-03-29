package com.spring.thiago.serviceTell;

import com.spring.thiago.model.Mail;
import com.spring.thiago.model.Tell;
import com.spring.thiago.model.User;

import java.util.List;

public interface TellService {

    List<Tell> findALlTell();

    Tell save(Tell tell);

    void deleteTell(long id);

    List<Tell> findAllTellId(int id);

    List<User> findALl();
}
