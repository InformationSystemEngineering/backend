package com.example.IIS.domain;

public class TopicCreationRequest {
    private Long requestId;
    private String name;
    private Long duration;
    private Long availableSpots;

    // Getters and Setters
    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getAvailableSpots() {
        return availableSpots;
    }

    public void setAvailableSpots(Long availableSpots) {
        this.availableSpots = availableSpots;
    }
}
