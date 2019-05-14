package com.awesome.AwesomeProject.repositories;

import com.awesome.AwesomeProject.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
