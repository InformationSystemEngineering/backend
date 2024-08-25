package com.example.IIS.dto;

import com.example.IIS.domain.Topic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TopicDto {
    private Long id;
    private String name;
    private Long duration;
    private Long availableSpots;
    private Long psychologistId;
    private Long reservationId;

//    public TopicDto(Long id, String name, Long duration, Long availableSpots, Long psychologistId, Long reservationId) {
//        this.id = id;
//        this.name = name;
//        this.duration = duration;
//        this.availableSpots = availableSpots;
//        this.psychologistId = psychologistId;
//        this.reservationId = reservationId;
//    }


}
