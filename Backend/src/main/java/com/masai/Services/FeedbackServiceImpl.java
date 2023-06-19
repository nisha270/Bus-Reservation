package com.masai.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.NoRecordFoundException;
import com.masai.Exceptions.NotFoundException;
import com.masai.Repository.FeedbackRepository;
import com.masai.models.Feedback;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired FeedbackRepository fRepo;

	 @Override
	    public Feedback addFeedback(Feedback feedback) {
	        return fRepo.save(feedback);
	    }

	    @Override
	    public Feedback updateFeedback(Feedback feedback)  {
	        
	        if (fRepo.existsById(feedback.getFeedbackId())) {
	            return fRepo.save(feedback);
	        } else {
	            
	            throw new NoRecordFoundException("Feedback with ID " + feedback.getFeedbackId() + " does not exist.");
	        }
	    }

	    @Override
	    public Feedback viewFeedback(int feedbackId) {
	        return fRepo.findById(feedbackId).orElse(null);
	    }

	    @Override
	    public List<Feedback> viewAllFeedbacks() {
	        
	        return fRepo.findAll();
	    }
	    
	    @Override
		public List<Feedback> getAllFeedbacksPageWise(Integer pageNumber, Integer numberOfRecords){
			// TODO Auto-generated method stub
			Pageable p = PageRequest.of(pageNumber - 1, numberOfRecords);
			Page<Feedback> page = fRepo.findAll(p);
			 List<Feedback> feed = page.getContent();
			return feed;
		}


}
