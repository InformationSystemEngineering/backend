package com.example.IIS.domain;

import java.sql.Time;

public class ReservationCreationRequest {
        private Time startTime;
        private Time endTime;
        private Long classroomId;

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public Long getClassroomId() {
        return classroomId;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }
}
