package com.example.IIS.service.impl;

import com.example.IIS.repository.TaskRepo;
import com.example.IIS.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepo taskRepo;
}
