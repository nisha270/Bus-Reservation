package com.masai.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.NotFoundException;
import com.masai.Repository.ReservationRepository;
import com.masai.Repository.UserRepository;
import com.masai.models.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;


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


//	@Override
//	public List<User> getSortedAndPaginatedUser(String field, String direction, Integer pageNumber, Integer numberOfRecords) {
//	    Sort sort = Sort.by(direction.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, field);
//	    Pageable pageable = PageRequest.of(pageNumber - 1, numberOfRecords, sort);
//	    Page<User> page = userRepository.findAll(pageable);
//	    return page.getContent();
//	}
//	
	
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

}
