package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masai.Services.AdminService;
import com.masai.models.Admin;
import com.masai.models.Bus;
import com.masai.models.Feedback;
import com.masai.models.User;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
//    @GetMapping("/hello")
//    public ResponseEntity<String> hello() {
//        String res= "hello welcome to Admin Controller";
//        return new ResponseEntity<>(res,HttpStatus.OK);
//    }

    @PostMapping("/register")
    public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) {
        String result = adminService.registerAdmin(admin);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/bus/{busId}")
    public ResponseEntity<Bus> viewBus(@PathVariable int busId) {
        Bus bus = adminService.viewBus(busId);
        return ResponseEntity.status(HttpStatus.OK).body(bus);
    }

    @PostMapping("/bus")
    public ResponseEntity<String> addBus(@RequestBody Bus bus) {
        String result = adminService.addBus(bus);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping("/bus/{busId}")
    public ResponseEntity<String> deleteBus(@PathVariable int busId) {
        String result = adminService.deleteBus(busId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/bus")
    public ResponseEntity<String> updateBus(@RequestBody Bus bus) {
        String result = adminService.updateBus(bus);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/bus")
    public ResponseEntity<List<Bus>> getAllBusPageWise(@RequestParam("pageNumber") Integer pageNumber,
                                                       @RequestParam("numberOfRecords") Integer numberOfRecords) {
        List<Bus> buses = adminService.getAllBusPageWise(pageNumber, numberOfRecords);
        return ResponseEntity.status(HttpStatus.OK).body(buses);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUserPageWise(@RequestParam("pageNumber") Integer pageNumber,
                                                         @RequestParam("numberOfRecords") Integer numberOfRecords) {
        List<User> users = adminService.getAllUserPageWise(pageNumber, numberOfRecords);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> viewUser(@PathVariable int userId) {
        User user = adminService.viewUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/feedbacks")
    public ResponseEntity<List<Feedback>> getAllFeedbacksPageWise(@RequestParam("pageNumber") Integer pageNumber,
                                                                  @RequestParam("numberOfRecords") Integer numberOfRecords) {
        List<Feedback> feedbacks = adminService.getAllFeedbacksPageWise(pageNumber, numberOfRecords);
        return ResponseEntity.status(HttpStatus.OK).body(feedbacks);
    }
}

