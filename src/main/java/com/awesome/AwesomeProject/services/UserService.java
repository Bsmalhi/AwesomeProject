package com.awesome.AwesomeProject.services;

import com.awesome.AwesomeProject.models.User;

public interface UserService {

    void save(User user);

    User findByUserName(String user);

}
