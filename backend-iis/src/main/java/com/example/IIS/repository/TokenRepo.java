package com.example.IIS.repository;

import com.example.IIS.domain.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepo extends JpaRepository<ConfirmationToken, Long> {
}
