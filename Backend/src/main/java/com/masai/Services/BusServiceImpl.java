package com.masai.Services;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.BusExceptions;
import com.masai.Repository.BusRepository;
import com.masai.Repository.RouteRepository;
import com.masai.models.Bus;
import com.masai.models.Route;


@Service
public class BusServiceImpl implements BusService{
	
	@Autowired
	BusRepository busRepository;
	
	@Autowired
	RouteRepository routeRepository;

	@Override
	public String addBus(Bus bus) {
		
//		Route busRoute = bus.getRoute();
//		
//		Optional<Route> opt = routeRepository.findById(busRoute);
		
		busRepository.save(bus);
		return "Bus successfully added";
	}

	@Override
	public String updateBus(Bus bus) {
		
		Integer busId = bus.getBusId();
		Optional<Bus> opt = busRepository.findById(busId);
		
		if(!opt.isPresent()) {
			throw new BusExceptions("Please enter valid bus Id");
		}
		Bus toUpdateBus = opt.get();
		
		toUpdateBus.setBusName(bus.getBusName());
		toUpdateBus.setDriverName(bus.getDriverName());
		toUpdateBus.setBusType(bus.getBusType());
		toUpdateBus.setRouteFrom(bus.getRouteFrom());
		toUpdateBus.setRouteTo(bus.getRouteTo());
		toUpdateBus.setSeats(bus.getSeats());
		toUpdateBus.setArrivalTime(bus.getArrivalTime());
		toUpdateBus.setDepartureTime(bus.getDepartureTime());
		toUpdateBus.setAvailableSeats(bus.getAvailableSeats());
		
		busRepository.save(toUpdateBus);
		
		
		return "Bus Successfully Updated";
		
	}

	@Override
	public String deleteBus(int busId) {
		
		Optional<Bus> opt = busRepository.findById(busId);
		if(!opt.isPresent()) {
			throw new BusExceptions("Please enter valid bus Id");
		}
		Bus busToBeDeleted = opt.get();
		busRepository.delete(busToBeDeleted);
		return "Bus successfully deleted";
	}

	@Override
	public Bus viewBus(int busId) {
		
		Optional<Bus> opt = busRepository.findById(busId);
		if(!opt.isPresent()) {
			throw new BusExceptions("Please enter valid bus Id");
		}
		Bus busDetail = opt.get();
		return busDetail;
	}

	@Override
	public List<Bus> viewBusByType(String busType) {
		List<Bus> allBus = busRepository.getBusByBusType(busType);
		return allBus;		
	}

	@Override
	public List<Bus> getAllBusPageWise(Integer pageNumber,Integer numberOfRecords){
		
		Pageable p = PageRequest.of(pageNumber - 1, numberOfRecords);
		Page<Bus> page = busRepository.findAll(p);
		 List<Bus> buses = page.getContent();
		return buses;
		
	}

	
}
