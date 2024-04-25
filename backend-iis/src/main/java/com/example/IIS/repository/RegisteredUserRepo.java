package com.example.IIS.repository;

import com.example.IIS.domain.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredUserRepo extends JpaRepository<RegisteredUser, Long> {
}
