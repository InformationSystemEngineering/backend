package com.example.IIS.service.impl;

import com.example.IIS.domain.*;
import com.example.IIS.dto.ApplicationDto;
import com.example.IIS.dto.TopicWithDetailsDto;
import com.example.IIS.repository.ApplicationRepository;
import com.example.IIS.repository.StudentRepo;
import com.example.IIS.repository.TopicRepository;
import com.example.IIS.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private StudentRepo studentRepository;

    public ApplicationDto applyForTopic(ApplicationDto applicationDto) {
        // Provera da li već postoji prijava sa istim studentId i topicId
//        Optional<Application> existingApplication = applicationRepository.findByStudentIdAndTopicId(applicationDto.getStudentId(), applicationDto.getTopicId());
//        if (existingApplication.isPresent()) {
//            throw new IllegalArgumentException("Application already exists for this student and topic.");
//        }

        // Kreiranje nove prijave
        Application application = new Application();
        application.setName(applicationDto.getName());
        application.setSurname(applicationDto.getSurname());
        application.setStudyYear(applicationDto.getStudyYear());
        application.setEmail(applicationDto.getEmail());

        // Postavljanje studenta i topic-a (prethodno preuzeti iz baze)
        Student student = studentRepository.findById(applicationDto.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("Student not found."));
        Topic topic = topicRepository.findById(applicationDto.getTopicId())
                .orElseThrow(() -> new IllegalArgumentException("Topic not found."));

        application.setStudent(student);
        application.setTopic(topic);

        // Smanjivanje broja availableSpots
        if (topic.getAvailableSpots() > 0) {
            topic.setAvailableSpots(topic.getAvailableSpots() - 1);
            topicRepository.save(topic); // Save the updated topic with the new availableSpots
        } else {
            throw new IllegalStateException("No available spots for this topic.");
        }

        // Čuvanje prijave
        Application savedApplication = applicationRepository.save(application);

        // Mapiranje entiteta u DTO
        ApplicationDto savedApplicationDto = new ApplicationDto(
                savedApplication.getStudent().getId(),
                savedApplication.getTopic().getId(),
                savedApplication.getName(),
                savedApplication.getSurname(),
                savedApplication.getStudyYear(),
                savedApplication.getEmail()
        );

        return savedApplicationDto;
    }

    public List<TopicWithDetailsDto> getTopicsByStudentId(Long studentId) {
        List<Application> applications = applicationRepository.findByStudentId(studentId);

        // Mapiranje prijava na DTO
        return applications.stream().map(application -> {
            Topic topic = application.getTopic();
            Reservation reservation = topic.getReservation();
            Classroom classroom = reservation.getClassroom();

            TopicWithDetailsDto topicDetailsDto = new TopicWithDetailsDto();
            topicDetailsDto.setTopicName(topic.getName());
            topicDetailsDto.setStartTime(reservation.getStartTime());
            topicDetailsDto.setEndTime(reservation.getEndTime());
            topicDetailsDto.setClassroomName(classroom.getName());
            topicDetailsDto.setFacultyName(topic.getFair().getRequest().getFaculty().getName());
            topicDetailsDto.setRequestName(topic.getFair().getRequest().getName());

            return topicDetailsDto;
        }).collect(Collectors.toList());
    }

}
