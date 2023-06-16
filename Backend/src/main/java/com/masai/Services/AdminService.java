package com.masai.Services;

import java.util.List;

import com.masai.models.Admin;
import com.masai.models.Bus;
import com.masai.models.Feedback;
import com.masai.models.User;

public interface AdminService {

	String registerAdmin(Admin admin);

	Admin getAdminByIdAndPassword(String adminId, String password);

	List<Bus> getAllBusPageWise(Integer pageNumber, Integer numberOfRecords);

	Bus viewBus(int busId);

	String addBus(Bus bus);

	String deleteBus(int busId);

	String updateBus(Bus bus);

	List<User> getAllUserPageWise(Integer pageNumber, Integer numberOfRecords);

	User viewUser(int userId);

	List<Feedback> getAllFeedbacksPageWise(Integer pageNumber, Integer numberOfRecords);

}
