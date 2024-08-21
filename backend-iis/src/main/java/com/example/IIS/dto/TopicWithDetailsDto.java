package com.example.IIS.dto;

import java.sql.Time;

public class TopicWithDetailsDto {
    private String topicName;
    private String classroomName;
    private Time startTime;
    private Time endTime;

    public TopicWithDetailsDto(String topicName, String classroomName, Time startTime, Time endTime) {
        this.topicName = topicName;
        this.classroomName = classroomName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Konstruktor, geteri i seteri


    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}

