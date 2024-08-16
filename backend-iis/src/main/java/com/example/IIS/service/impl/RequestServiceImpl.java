package com.example.IIS.service.impl;

import com.example.IIS.domain.Request;
import com.example.IIS.domain.Workshop;
import com.example.IIS.dto.RequestDto;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.repository.RequestRepository;
import com.example.IIS.service.RequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    RequestRepository requestRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private EmailSender emailSender;

    @Value("${spring.mail.username}") // Ubrizgavanje email adrese iz konfiguracije
    private String senderEmail;

    private RequestDto mapToDTO(Request request){
        RequestDto requestDto = mapper.map(request, RequestDto.class);
        return requestDto;
    }

    // convert DTO to entity
    private Request mapToEntity(RequestDto requestDto){
        Request request = mapper.map(requestDto, Request.class);
        return request;
    }

    @Override
    public RequestDto createRequest(RequestDto requestDto) {

        Request request = mapToEntity(requestDto);
        Request newRequest = requestRepository.save(request);

        RequestDto RequestResponse = mapToDTO(newRequest);

        //sendRequestCreatedEmail(requestDto);
        return RequestResponse;


    }

    private void sendRequestCreatedEmail(RequestDto requestDto) {
        // Kreiramo DTO za slanje emaila. Možete koristiti requestDto za prilagodbu poruke.
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("katarina.medic01@gmail.com"); // Zakucani email
        mail.setFrom(senderEmail); // Koristimo email adresu iz konfiguracije
        mail.setSubject("Request Created!");
        mail.setText("A new request has been created with ID: " + requestDto.getId());

        emailSender.sendEmail(mail);
    }
}
