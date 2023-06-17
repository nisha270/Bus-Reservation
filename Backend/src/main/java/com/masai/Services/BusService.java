package com.masai.Services;

import java.util.List;

import com.masai.models.Bus;

public interface BusService {
    Bus addBus(Bus bus);
    Bus updateBus(Bus bus);
    Bus deleteBus(int busId);
    Bus viewBus(int busId);
    List<Bus> viewBusByType(String busType);
    List<Bus> viewAllBuses();
}
