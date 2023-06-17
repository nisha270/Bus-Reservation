package com.masai.Services;

import java.util.List;

import com.masai.models.Bus;

public interface BusService {
    String addBus(Bus bus, Integer routeId);
    String updateBus(Bus bus);
    String deleteBus(int busId);
    Bus viewBus(int busId);
    List<Bus> viewBusByType(String busType);
    List<Bus> getAllBusPageWise(Integer pageNumber,Integer numberOfRecords);
}
