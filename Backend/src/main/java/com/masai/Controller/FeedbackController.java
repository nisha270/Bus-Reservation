package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.masai.Services.FeedbackService;
import com.masai.models.Feedback;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@Controller
public class FeedbackController {
	
	@Autowired
    private FeedbackService feedbackService;

    @PostMapping("/feebacks")
    public ResponseEntity<Feedback> addFeedback( @Valid @RequestBody Feedback feedback) {
        Feedback addedFeedback = feedbackService.addFeedback(feedback);
        return new ResponseEntity<>(addedFeedback, HttpStatus.CREATED);
    }

    @PutMapping("/feedback{feedbackId}")
    public ResponseEntity<Feedback> updateFeedback(@Valid  @PathVariable int feedbackId, @RequestBody Feedback feedback) {
        feedback.setFeedbackId(feedbackId);
        Feedback updatedFeedback = feedbackService.updateFeedback(feedback);
        return new ResponseEntity<>(updatedFeedback, HttpStatus.OK);
    }

    @GetMapping("/{feedbackId}")
    public ResponseEntity<Feedback> viewFeedback(@PathVariable int feedbackId) {
        Feedback feedback = feedbackService.viewFeedback(feedbackId);
        if (feedback != null) {
            return new ResponseEntity<>(feedback, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/feedbacks")
    public ResponseEntity<List<Feedback>> viewAllFeedbacks() {
        List<Feedback> feedbacks = feedbackService.viewAllFeedbacks();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

}
