package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.NotFoundException;
import com.masai.Services.UserService;
import com.masai.models.User;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) throws NotFoundException {
		return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable Integer userId) throws NotFoundException {
		return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
	}

	@PutMapping("updateUser/{uid}")
	public ResponseEntity<User> UpdateUserDatails(@PathVariable Integer uid, @RequestBody User user)
			throws NotFoundException {
		return new ResponseEntity<>(userService.updateUser(uid, user), HttpStatus.ACCEPTED);
	}

	@GetMapping("/user/{uid}")
	public ResponseEntity<User> getuserByUserId(@PathVariable Integer uid) throws NotFoundException {
		return new ResponseEntity<>(userService.getUserDetailbyUserId(uid), HttpStatus.OK);
	}

	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getSortedAndPaginatedUsers(@RequestParam String field,
			@RequestParam String direction, @RequestParam Integer pageNumber, @RequestParam Integer numberOfRecords) {
		return new ResponseEntity<>(
				userService.getAllUserPageWise(pageNumber, numberOfRecords), HttpStatus.OK);
	}

	@GetMapping("/allUsers")
	public ResponseEntity<List<User>> getallUsers() throws NotFoundException {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

}
