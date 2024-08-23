package com.example.IIS.dto;

import com.example.IIS.domain.Psychologist;
import com.example.IIS.domain.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private Long id;
    private Long userId;
    private String userName;
    private Long psychologistId;
    private String psychologistName;
    private String content;
    private boolean isRead;
    private String sender;
    private Long topicId;
}
