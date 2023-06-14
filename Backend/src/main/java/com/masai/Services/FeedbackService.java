package com.masai.Services;

import java.util.List;

import com.masai.models.Feedback;

public interface FeedbackService {
	Feedback addFeedback(Feedback feedback);
	Feedback updateFeedback(Feedback feedback);
	Feedback viewFeedback(int feedbackId);
    List<Feedback> viewAllFeedbacks();
}
