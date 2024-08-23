package com.example.IIS.service.impl;

import com.example.IIS.domain.Message;
import com.example.IIS.domain.Psychologist;
import com.example.IIS.domain.Topic;
import com.example.IIS.domain.User;
import com.example.IIS.dto.MessageDto;
import com.example.IIS.repository.MessageRepository;
import com.example.IIS.repository.PsychologistRepo;
import com.example.IIS.repository.TopicRepository;
import com.example.IIS.repository.UserRepository;
import com.example.IIS.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PsychologistRepo psychologistRepository;
    @Autowired
    private TopicRepository topicRepository;

    // Convert Message entity to MessageDto
    public MessageDto convertToDto(Message message) {
        return new MessageDto(
                message.getId(),
                message.getUser().getId(),
                message.getUser().getName(),
                message.getPsychologist().getId(),
                message.getPsychologist().getName(),
                message.getContent(),
                message.isRead(),
                message.getSender(),
                message.getTopic().getId()
        );
    }

    // Convert MessageDto to Message entity
    public Message convertToEntity(MessageDto messageDto) {
        User user = userRepository.findById(messageDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Psychologist psychologist = psychologistRepository.findById(messageDto.getPsychologistId())
                .orElseThrow(() -> new RuntimeException("Psychologist not found"));
        Topic topic = topicRepository.findById(messageDto.getTopicId())
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        Message message = new Message();
        message.setId(messageDto.getId());
        message.setUser(user);
        message.setPsychologist(psychologist);
        message.setTopic(topic);
        message.setContent(messageDto.getContent());
        message.setSender(messageDto.getSender());
        message.setRead(messageDto.isRead());

        return message;
    }

    // Get messages by topic ID and psychologist ID
    @Override
    public List<MessageDto> getMessages(Long topicId, Long psychologistId) {
        return messageRepository.findByTopicIdAndPsychologistId(topicId, psychologistId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Add a new message
    @Override
    public MessageDto addMessage(MessageDto messageDto) {
        Message message = convertToEntity(messageDto);
        Message savedMessage = messageRepository.save(message);
        return convertToDto(savedMessage);
    }

    // Mark a message as read
    @Override
    public void readMessage(Long messageId) {
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new RuntimeException("Message not found"));
        message.setRead(true);
        messageRepository.save(message);
    }
}
