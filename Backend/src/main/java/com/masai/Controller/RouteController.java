package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.masai.Repository.RouteRepository;
import com.masai.Services.RouteService;
import com.masai.models.Bus;
import com.masai.models.Route;

@Controller
public class RouteController {
	
	@Autowired
	RouteService routeService;
	
	
	
	@PostMapping("/addRoute")
	public ResponseEntity<Route> addRoute(@RequestBody Route route){
		Route response = routeService.addRoute(route);
		return new ResponseEntity<Route>(response,HttpStatus.OK);
		
	}
	
	@PatchMapping("/updateRoute")
	public ResponseEntity<String> updateRoute(@RequestBody Route route){
		String response = routeService.updateRoute(route);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteRoute/{routeId}")
	public ResponseEntity<String> deleteRoute(@PathVariable Integer routeId){
		String response = routeService.deleteRoute(routeId);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@GetMapping("/viewRoute/{routeId}")
	public ResponseEntity<Route> viewRoute(@PathVariable Integer routeId){
		Route response = routeService.viewRoute(routeId);
		return new ResponseEntity<Route>(response,HttpStatus.OK);
	}
	
	@GetMapping("students/{pageNumber}/{numberOfRecords}")
	public ResponseEntity<List<Route>> viewAllRoutesPageWise(@PathVariable("pageNumber") Integer pageNumber,
									@PathVariable("numberOfRecords") Integer numberOfRecords){
		List<Route> routeList =  routeService.viewAllRoutesPageWise(numberOfRecords, pageNumber);
		return new ResponseEntity<List<Route>>(routeList,HttpStatus.OK); 
	}
	
	

	
	
}
