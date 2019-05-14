package com.awesome.AwesomeProject.services;

import com.awesome.AwesomeProject.models.User;
import com.awesome.AwesomeProject.repositories.RoleRepository;
import com.awesome.AwesomeProject.repositories.UserRepository;
import com.awesome.AwesomeProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
