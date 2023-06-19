package com.masai.Services;

import java.util.List;

import com.masai.Exceptions.NotFoundException;
import com.masai.models.User;

public interface UserService {
	
	public User addUser(User user) throws NotFoundException;

	public User deleteUser(int userId) throws NotFoundException;

	public User updateUser(Integer uid , User user) throws NotFoundException;

	public User getUserDetailbyUserId(Integer uid) throws NotFoundException;
	
	public List<User> getAllUserPageWise(Integer pageNumber, Integer numberOfRecords);
	
	public List<User> getAllUsers() throws NotFoundException;

}
