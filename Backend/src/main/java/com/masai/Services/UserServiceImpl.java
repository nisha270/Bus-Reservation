package com.masai.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.NotFoundException;
import com.masai.Repository.BusRepository;
import com.masai.Repository.FeedbackRepository;
import com.masai.Repository.ReservationRepository;
import com.masai.Repository.RouteRepository;
import com.masai.Repository.UserRepository;
import com.masai.models.Bus;
import com.masai.models.Feedback;
import com.masai.models.Reservation;
import com.masai.models.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private BusRepository busRepository;
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private RouteRepository routeRepository;

	@Override
	public User addUser(User user) throws NotFoundException {

		if(user==null)
			throw new NotFoundException("User Details are Null");
		
		User exsistUser= userRepository.findById(user.getUserLoginId()).orElse(null);
		if(exsistUser!=null) {
			throw new NotFoundException("Customer already Exsist");
			
		}
		else {
			return userRepository.save(user);
		}
	}

	@Override
	public User deleteUser(int userId) throws NotFoundException {
		User exsistUser= userRepository.findById(userId).orElse(null);
		if(exsistUser==null)
			throw new NotFoundException("User Details are not Found");
		else {
			 userRepository.deleteById(userId);
			 return exsistUser;
		}
	}

	@Override
	public User updateUser(Integer uid, User user) throws NotFoundException {
		User exsistUser= userRepository.findById(uid).orElse(null);
		if(exsistUser==null)
			throw new NotFoundException("User Details are not Found");
		if (user.getUserName() != null)
			exsistUser.setUserName(user.getUserName());
		
		if (user.getPassword() != null)
			exsistUser.setPassword(user.getPassword());
		
		if (user.getFirstName() != null)
			exsistUser.setFirstName(user.getFirstName());
		
		if (user.getLastName() != null)
			exsistUser.setLastName(user.getLastName());
		
		if (user.getContact() != null) {
		    exsistUser.setContact(user.getContact());
		}
		
		 if (user.getReservations() != null) {
		        exsistUser.setReservations(user.getReservations());
		    }
		    return userRepository.save(exsistUser);

	}
	
	@Override
	public User getUserDetailbyUserId(Integer uid) throws NotFoundException {
		User exsistUser= userRepository.findById(uid).orElse(null);
		if(exsistUser==null)
			throw new NotFoundException("User Details are not Found");
		else {
			 return exsistUser;
		}
	}

	@Override
	public List<User> getAllUserPageWise(Integer pageNumber, Integer numberOfRecords) {
		
		Pageable p = PageRequest.of(pageNumber - 1, numberOfRecords);
		Page<User> page = userRepository.findAll(p);
		 List<User> Users = page.getContent();
		return Users;
	}

	@Override
	public List<User> getAllUsers() throws NotFoundException {
		List<User> users= userRepository.findAll();
		if(users.isEmpty()) {
			throw new NotFoundException("Data not Found");
		}
		
		return users;
	}

//	@Override
//	public String login(String username, String password) throws NotFoundException{
//		 User user = userRepository.findByUserName(username);
//		 if(user==null)
//			 throw new NotFoundException("Something went Wrong!");
//	        if (user != null && user.getPassword().equals(password)) {
//	           return "Login Successfully";
//	        }
//			return "UserName or Possword Wrong";
//	        
//	}
//
//	@Override
//	public Reservation bookTicket(String username, String destination, String busName) throws NotFoundException {
//		User user = userRepository.findByUserName(username);
//        if (user == null) {
//            throw new NotFoundException("User not found");
//        }
//        
//       
//        return null;
//
//	}
//
//	@Override
//	public Feedback submitFeedback(int userId, int busId, String feedbackText) throws NotFoundException {
//		User user = userRepository.findById(userId)
//                .orElseThrow(() -> new NotFoundException("User not found."));
//
//		return null;
//	}
//
//	@Override
//	public Feedback updateFeedback(int feedbackId, String updatedFeedbackText) throws NotFoundException {
//		Feedback feedback = feedbackRepository.findById(feedbackId)
//                .orElseThrow(() -> new NotFoundException("Feedback not found."));
//
//        feedback.setComments(updatedFeedbackText);
//
//        return feedbackRepository.save(feedback);
//	}
//
//	@Override
//	public Page<Reservation> getAllReservations(int userId, Pageable pageable) throws NotFoundException {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new NotFoundException("User not found."));
//
//        return reservationRepository.findAllByUser(user, pageable);
//    }

}
