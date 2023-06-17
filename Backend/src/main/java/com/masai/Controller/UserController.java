package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import com.masai.Services.FeedbackService;
import com.masai.Services.UserService;
import com.masai.models.Feedback;
import com.masai.models.Reservation;
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

//	
//	@GetMapping("/login")
//	public ResponseEntity<String> login(@RequestParam("username") String username,@RequestParam("password") String password) throws NotFoundException{
//		
//		return new ResponseEntity<>(userService.login(username, password),HttpStatus.OK);
//	}
//	
////	@PostMapping("/bookTickets/{username}")
////	public ResponseEntity<Reservation> bookTicket(@RequestParam String username,@RequestBody Reservation res) throws NotFoundException {
////		return new ResponseEntity<>(userService.bookTicket(username, res),HttpStatus.ACCEPTED);
////		
////	}
//	
//	@PutMapping("/updateFeedback/{feedbackId}")
//	public ResponseEntity<Feedback> updateFeedback(@PathVariable int feedbackId,@PathVariable String updatedFeedbackText) throws NotFoundException {
//	
//		return new ResponseEntity<>(userService.updateFeedback(feedbackId, updatedFeedbackText),HttpStatus.OK);
//	}
//	
//	@GetMapping("allResevationByUserId/{userId}")
//	public ResponseEntity<Page<Reservation>> getAllReservations(@PathVariable("userId") int userId,
//            @RequestParam(value = "page", defaultValue = "0") int page,
//            @RequestParam(value = "size", defaultValue = "10") int size) throws NotFoundException{
//		
//		Pageable pageable = PageRequest.of(page, size, Sort.by("reservationDate").descending());
//		return new ResponseEntity<>(userService.getAllReservations(userId, pageable),HttpStatus.OK);
//	}
	
}
