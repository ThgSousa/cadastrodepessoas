package com.spring.thiago.serviceTell;

import com.spring.thiago.model.Tell;
import com.spring.thiago.model.User;
import com.spring.thiago.repository.TellRepository;
import com.spring.thiago.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceTellimpl implements TellService {
    @Autowired
    TellRepository repo;
    UserRepository repoU;

    @Override
    public List<Tell> findALlTell() {
        return repo.findAll();
    }


    @Override
    public Tell save(Tell tell) {
        return repo.save(tell);
    }

    @Override
    public void deleteTell(long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Tell> findAllTellId(int id) {
        return repo.findAllTellId(id);
    }

    @Override
    public List<User> findALl() {
        return repoU.findAll();
    }


}
