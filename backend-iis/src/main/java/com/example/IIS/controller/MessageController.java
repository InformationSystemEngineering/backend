package com.example.IIS.controller;

import com.example.IIS.domain.Message;
import com.example.IIS.dto.MessageDto;
import com.example.IIS.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping
    public ResponseEntity<List<MessageDto>> getMessages(@RequestParam Long topicId, @RequestParam Long psychologistId) {
        List<MessageDto> messages = messageService.getMessages(topicId, psychologistId);
        return ResponseEntity.ok(messages);
    }

    // Add a new message
    @PostMapping
    public ResponseEntity<MessageDto> addMessage(@RequestBody MessageDto messageDto) {
        MessageDto savedMessage = messageService.addMessage(messageDto);
        return ResponseEntity.ok(savedMessage);
    }

    // Mark a message as read
    @PutMapping("/{messageId}/read")
    public ResponseEntity<Void> readMessage(@PathVariable Long messageId) {
        messageService.readMessage(messageId);
        return ResponseEntity.ok().build();
    }
}
