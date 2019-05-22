package com.awesome.AwesomeProject.repositories;

import com.awesome.AwesomeProject.models.Role;
import com.awesome.AwesomeProject.models.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    // to retrieve the role from RoleName
    Optional<Role> findByName(RoleName roleName);
}
