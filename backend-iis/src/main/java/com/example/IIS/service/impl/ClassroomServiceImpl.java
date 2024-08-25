package com.example.IIS.service.impl;

import com.example.IIS.domain.*;
import com.example.IIS.dto.ClassroomDateDto;
import com.example.IIS.dto.ClassroomDto;
import com.example.IIS.dto.FacultyDto;
import com.example.IIS.dto.FairDto;
import com.example.IIS.repository.ClassroomRepository;
import com.example.IIS.repository.FacultyRepository;
import com.example.IIS.repository.ReservationRepository;
import com.example.IIS.repository.TopicRepository;
import com.example.IIS.service.ClassroomService;
import com.example.IIS.service.FacultyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    private ModelMapper mapper;

    private ClassroomDto mapToDTO(Classroom classroom){
        ClassroomDto classroomDto = mapper.map(classroom, ClassroomDto.class);
        return classroomDto;
    }

    // convert DTO to entity
    private Classroom mapToEntity(ClassroomDto classroomDto){
        Classroom classroom = mapper.map(classroomDto, Classroom.class);
        return classroom;
    }

    @Override
    public List<ClassroomDto> getAllClassroomsByRequestId(long requestId) {
        List<Classroom> classrooms=classroomRepository.findAll();
        ClassroomDto classroomDto=new ClassroomDto();
        List<ClassroomDto> classroomDtos =new ArrayList<ClassroomDto>();

        for (Classroom classroom : classrooms) {
            if(classroom.getRequest().getId() == requestId){
                classroomDto=mapToDTO(classroom);
                classroomDtos.add(classroomDto);
            }
        }
        return classroomDtos;
    }

    // Convert Classroom entity to ClassroomDto
    public ClassroomDto convertToDto(Classroom classroom) {
        return new ClassroomDto(
                classroom.getId(),
                classroom.getName(),
                classroom.getDate(),
                classroom.getStartTime(),
                classroom.getEndTime(),
                classroom.getFloor(),
                classroom.getCapacity()
        );
    }

    @Override
    public Optional<ClassroomDto> getClassroomById(Long classroomId) {
        return classroomRepository.findById(classroomId)
                .map(this::convertToDto);
    }

    // New method to fetch classrooms by requestId
    @Override
    public List<ClassroomDto> getClassroomsByRequestId(Long requestId) {
        List<Classroom> classrooms = classroomRepository.findClassroomsByRequestId(requestId);
        return classrooms.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // New method to get classroom date by topic ID
    public Optional<ClassroomDateDto> getClassroomDateByTopicId(Long topicId) {
        // Find the Topic by ID
        Optional<Topic> topicOpt = topicRepository.findById(topicId);

        if (topicOpt.isPresent()) {
            Topic topic = topicOpt.get();
            Long reservationId = topic.getReservation().getId();

            // Find the Reservation by ID
            Optional<Reservation> reservationOpt = reservationRepository.findById(reservationId);

            if (reservationOpt.isPresent()) {
                Reservation reservation = reservationOpt.get();
                Long classroomId = reservation.getClassroom().getId();

                // Find the Classroom by ID
                Optional<Classroom> classroomOpt = classroomRepository.findById(classroomId);

                if (classroomOpt.isPresent()) {
                    Classroom classroom = classroomOpt.get();
                    // Create DTO to send back
                    return Optional.of(new ClassroomDateDto(classroom.getId(), classroom.getDate()));
                }
            }
        }
        return Optional.empty();
    }
}
