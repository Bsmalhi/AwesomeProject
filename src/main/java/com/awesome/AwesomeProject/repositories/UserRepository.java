package com.awesome.AwesomeProject.repositories;

import com.awesome.AwesomeProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
}
