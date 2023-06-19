package com.masai.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.BusExceptions;
import com.masai.Exceptions.RouteException;
import com.masai.Repository.RouteRepository;
import com.masai.models.Bus;
import com.masai.models.Route;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Service
public class RouteServiceImpl implements RouteService {
	
	@Autowired
	RouteRepository routeRepository;

	@Override
	public Route addRoute(Route route) {
		route.setBuses(new ArrayList<Bus>());
		routeRepository.save(route);
		return route;
	}

	@Override
	public String updateRoute(Route route) {
		
		Integer routeId = route.getRouteId();
		Optional<Route> opt = routeRepository.findById(routeId);
		
		if(!opt.isPresent()) {
			throw new BusExceptions("Please enter valid bus Id");
		}
		Route toUpdateRoute = opt.get();
		toUpdateRoute.setRouteTo(route.getRouteTo());
		toUpdateRoute.setRouteFrom(route.getRouteFrom());
		toUpdateRoute.setDistance(route.getDistance());
		routeRepository.save(toUpdateRoute);
		return "Bus Successfully Updated";
	}

	@Override
	public String deleteRoute(int routeId) {
		
		Optional<Route> opt = routeRepository.findById(routeId);
		
		if(!opt.isPresent()) {
			throw new RouteException("Please enter valid route Id");
		}
		
		Route route = opt.get();
		routeRepository.delete(route);
		return "route successfully deleted";
	}

	@Override
	public Route viewRoute(int routeId) {
		
		Optional<Route> opt = routeRepository.findById(routeId);
		if(!opt.isPresent()) {
			throw new RouteException("Please enter valid route Id");
		}
		Route route = opt.get();
		return route;
	}

	@Override
	public List<Route> viewAllRoutesPageWise(Integer pageNumber,Integer numberOfRecords) {

		Pageable p = PageRequest.of(pageNumber - 1, numberOfRecords);
		Page<Route> page = routeRepository.findAll(p);
		List<Route> route = page.getContent();
		return route;
				
	}
	

}
