package com.example.IIS.domain;

public class UpdatePsychologistRequest {
    private String topicName;
    private Long psychologistId;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Long getPsychologistId() {
        return psychologistId;
    }

    public void setPsychologistId(Long psychologistId) {
        this.psychologistId = psychologistId;
    }
}
