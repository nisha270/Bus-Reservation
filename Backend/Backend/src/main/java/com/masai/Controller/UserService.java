package com.masai.Controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.masai.Exceptions.NotFoundException;
import com.masai.models.User;

public interface UserService {

	public User addUser(User user) throws NotFoundException;

	public User deleteUser(int userId) throws NotFoundException;

	public User updateUser(Integer uid, User user) throws NotFoundException;

	public User getUserDetailbyUserId(Integer uid) throws NotFoundException;

	public List<User> getSortUserListByField(String field, String direction);

	public List<User> getAllUserPageWise(Integer pageNumber, Integer NumberOfRecords);

	public List<User> getSortedAndPaginatedUser(String field, String direction, Integer pageNumber,
			Integer numberOfRecords);

	public List<User> getAllUsers() throws NotFoundException;
}
