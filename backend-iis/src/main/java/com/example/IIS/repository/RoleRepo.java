package com.example.IIS.repository;

import com.example.IIS.domain.Role;
import com.example.IIS.domain.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);


}