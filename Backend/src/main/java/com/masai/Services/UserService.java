package com.masai.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.masai.Exceptions.NotFoundException;
import com.masai.models.Bus;
import com.masai.models.Feedback;
import com.masai.models.Reservation;
import com.masai.models.User;

public interface UserService {
	
	public User addUser(User user) throws NotFoundException;

	public User deleteUser(int userId) throws NotFoundException;

	public User updateUser(Integer uid , User user) throws NotFoundException;

	public User getUserDetailbyUserId(Integer uid) throws NotFoundException;
	
	public List<User> getAllUserPageWise(Integer pageNumber, Integer numberOfRecords);
	
	public List<User> getAllUsers() throws NotFoundException;
	
	
	
	public String login(String username, String password) throws NotFoundException;
	
	public Reservation bookTicket(String username,String destination, String busName) throws NotFoundException;
	
    public Feedback submitFeedback(int userId, int busId, String feedbackText) throws NotFoundException;
    
    public Feedback updateFeedback(int feedbackId, String updatedFeedbackText) throws NotFoundException;
    
    public Page<Reservation> getAllReservations(int userId, Pageable pageable)throws NotFoundException;
      
}
