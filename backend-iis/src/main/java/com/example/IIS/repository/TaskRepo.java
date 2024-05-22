package com.example.IIS.repository;
import com.example.IIS.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
}
