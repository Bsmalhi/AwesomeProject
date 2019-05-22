package com.awesome.AwesomeProject.services;

import com.awesome.AwesomeProject.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void save(User user);

    User findByUserName(String user);

}
