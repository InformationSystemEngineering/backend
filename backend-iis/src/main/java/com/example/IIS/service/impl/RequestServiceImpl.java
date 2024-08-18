package com.example.IIS.service.impl;

import com.example.IIS.domain.Faculty;
import com.example.IIS.domain.Request;
import com.example.IIS.domain.Workshop;
import com.example.IIS.domain.enums.Status;
import com.example.IIS.dto.*;
import com.example.IIS.repository.RequestRepository;
import com.example.IIS.service.ClassroomService;
import com.example.IIS.service.FairService;
import com.example.IIS.service.RequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    RequestRepository requestRepository;

    @Autowired
    private FairService fairService;

    @Autowired
    private ClassroomService classroomService;

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


    @Override
    public List<RequestDto> getAllAcceptedRequest() {
        List<Request> requests=requestRepository.findAll();
        RequestDto requestDto= new RequestDto();
        List<RequestDto> requestDtos =new ArrayList<RequestDto>();

        for (Request request : requests) {
            if(request.getStatus().equals(Status.ACCEPTED)){
                requestDto=mapToDTO(request);
                requestDtos.add(requestDto);
            }
        }
        return requestDtos;
    }

    public RequestDetailDto getRequestDetailsById(long requestId) {
        Optional<Request> optionalRequest = requestRepository.findById(requestId);
        if (!optionalRequest.isPresent()) {
            return null; // Vraćamo null ako Request nije pronađen
        }

        RequestDto request = mapToDTO(optionalRequest.get());
        FairDto fair = fairService.getFairByRequestId(requestId); // 1:1 veza, samo jedan Fair
        List<ClassroomDto> classrooms = classroomService.getAllClassroomsByRequestId(requestId);

        RequestDetailDto requestDetailDto = new RequestDetailDto();
        requestDetailDto.setRequest(request);
        requestDetailDto.setFair(fair);
        requestDetailDto.setClassrooms(classrooms);

        return requestDetailDto;
    }


    public List<RequestDetailDto> getAllAcceptedRequestDetails() {
        List<Request> acceptedRequests = requestRepository.findByStatus(Status.ACCEPTED);
        List<RequestDetailDto> requestDetailDtos = new ArrayList<>();

        for (Request request : acceptedRequests) {
            RequestDto requestDto = mapToDTO(request);
            FairDto fair = fairService.getFairByRequestId(request.getId());
            List<ClassroomDto> classrooms = classroomService.getAllClassroomsByRequestId(request.getId());

            RequestDetailDto requestDetailDto = new RequestDetailDto();
            requestDetailDto.setRequest(requestDto);
            requestDetailDto.setFair(fair);
            requestDetailDto.setClassrooms(classrooms);

            requestDetailDtos.add(requestDetailDto);
        }

        return requestDetailDtos;
    }

}
