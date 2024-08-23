package com.example.IIS.service;

import com.example.IIS.domain.Message;
import com.example.IIS.dto.MessageDto;

import java.util.List;

public interface MessageService {
    List<MessageDto> getMessages(Long topicId, Long psychologistId);
    MessageDto addMessage(MessageDto messageDto);
    void readMessage(Long messageId);
}
