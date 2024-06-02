package com.example.IIS.controller;

import com.example.IIS.dto.FeedbackFairDto;
import com.example.IIS.dto.FeedbackReportDto;
import com.example.IIS.service.FeedbackFairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacksFair")
public class FeedbackFairController {
    @Autowired
    FeedbackFairService feedbackFairService;

    @PostMapping
    public ResponseEntity<FeedbackFairDto> createFeedback(@RequestBody FeedbackFairDto feedbackFairDto){
        return new ResponseEntity<>(feedbackFairService.createFeedback(feedbackFairDto), HttpStatus.CREATED);
    }

    @GetMapping("/{extraActivityId}")
    public ResponseEntity<List<FeedbackFairDto>> getFeedbacksByExtraActivity(@PathVariable("extraActivityId") long extraActivityId) {
        List<FeedbackFairDto> extraActivities = feedbackFairService.getAllByExtraActivityId(extraActivityId);
        if (extraActivities.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(extraActivities);
    }

    @GetMapping("/report")
    public ResponseEntity<FeedbackReportDto> getFeedbackReport() {
        List<FeedbackFairDto> fairs = feedbackFairService.getAll();
        FeedbackReportDto report = new FeedbackReportDto(fairs);
        return ResponseEntity.ok(report);
    }
}
