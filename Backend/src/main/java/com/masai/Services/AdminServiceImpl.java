package com.masai.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.BusExceptions;
import com.masai.Exceptions.SomethingWrongException;
import com.masai.Repository.AdminRepository;
import com.masai.Repository.BusRepository;
import com.masai.Repository.FeedbackRepository;
import com.masai.Repository.UserRepository;
import com.masai.models.Admin;
import com.masai.models.Bus;
import com.masai.models.Feedback;
import com.masai.models.User;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	BusRepository busRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public String registerAdmin(Admin admin) {
		adminRepository.save(admin);
		return "Signup successful";
	}	
	
	@Override
	public Admin getAdminByIdAndPassword(String adminId, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Bus> getAllBusPageWise(Integer pageNumber,Integer numberOfRecords){
		
		Pageable p = PageRequest.of(pageNumber - 1, numberOfRecords);
		Page<Bus> page = busRepository.findAll(p);
		 List<Bus> buses = page.getContent();
		return buses;
		
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
	public String addBus(Bus bus) {
		busRepository.save(bus);
		return "Bus successfully added";
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
	public String updateBus(Bus bus) {
		
		Integer busId = bus.getBusId();
		Optional<Bus> opt = busRepository.findById(busId);
		
		if(!opt.isPresent()) {
			throw new BusExceptions("Please enter valid bus Id");
		}
		Bus toUpdateBus = opt.get();
		
		toUpdateBus.setDriverName(bus.getDriverName());
		toUpdateBus.setRouteFrom(bus.getRouteFrom());
		toUpdateBus.setRouteTo(bus.getRouteTo());
		toUpdateBus.setArrivalTime(bus.getArrivalTime());
		toUpdateBus.setDepartureTime(bus.getDepartureTime());
		toUpdateBus.setAvailableSeats(bus.getAvailableSeats());
		
		busRepository.save(toUpdateBus);
		
		
		return "Bus Successfully Updated";
		
	}

	@Override
	public List<User> getAllUserPageWise(Integer pageNumber, Integer numberOfRecords) {
		
		Pageable p = PageRequest.of(pageNumber - 1, numberOfRecords);
		Page<User> page = userRepository.findAll(p);
		 List<User> Users = page.getContent();
		return Users;
	}


	@Override
	public User viewUser(int userId) {
		// TODO Auto-generated method stub
		Optional<User> opt = userRepository.findById(userId);
		if(!opt.isPresent()) {
			throw new SomethingWrongException("Please enter valid bus Id");
		}
		User userDetail = opt.get();
		return userDetail;
		
	}

	@Override
	public List<Feedback> getAllFeedbacksPageWise(Integer pageNumber, Integer numberOfRecords){
		// TODO Auto-generated method stub
		Pageable p = PageRequest.of(pageNumber - 1, numberOfRecords);
		Page<Feedback> page = feedbackRepository.findAll(p);
		 List<Feedback> feedbacks = page.getContent();
		return feedbacks;
	}


}
