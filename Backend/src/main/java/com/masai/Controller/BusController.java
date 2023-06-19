package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Services.BusService;
import com.masai.mail.EmailService;
import com.masai.models.Bus;

import jakarta.mail.MessagingException;
import jakarta.persistence.PersistenceUnit;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BusController {
	
	@Autowired
	BusService busService;
	
	@Autowired
	EmailService emailService;
	
	@PostMapping("/addBus/{routeId}")
	public ResponseEntity<String> addBus(@Valid @RequestBody Bus bus, 
					@PathVariable Integer routeId){
		String response = busService.addBus(bus, routeId);
		
		return new ResponseEntity<String>(response,HttpStatus.CREATED);
		
	}

	@PatchMapping("/updateBus")
	public ResponseEntity<String> updateBus(@Valid @RequestBody Bus bus){
		String response = busService.updateBus(bus);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteBus/{busId}")
	public ResponseEntity<String> deleteBus(@Valid @PathVariable Integer busId){
		String response = busService.deleteBus(busId);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@GetMapping("/viewBus/{busId}")
	public ResponseEntity<Bus> viewBus(@Valid @PathVariable Integer busId){
		Bus bus= busService.viewBus(busId);
		return new ResponseEntity<Bus>(bus,HttpStatus.OK);
	}

	
	@GetMapping("/viewBusByType/{busType}")
	public ResponseEntity<List<Bus>> viewBusByType(@PathVariable String busType){
		List<Bus> busList = busService.viewBusByType(busType);
		return new ResponseEntity<List<Bus>>(busList,HttpStatus.OK);
	}
	

	@GetMapping("buses/{pageNumber}/{numberOfRecords}")
	public ResponseEntity<List<Bus>> getStudentPageWiseHandler(@PathVariable("pageNumber") Integer pageNumber,
			@PathVariable("numberOfRecords") Integer numberOfRecords){
		
		List<Bus> busList = busService.getAllBusPageWise(pageNumber, numberOfRecords);
		return new ResponseEntity<List<Bus>>(busList,HttpStatus.OK);
	}
		
	
}
