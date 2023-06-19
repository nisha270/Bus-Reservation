package com.masai.Services;

import java.util.List;

import com.masai.models.Route;

public interface RouteService {
    Route addRoute(Route route);
    String updateRoute(Route route);
    String deleteRoute(int routeId);
    Route viewRoute(int routeId);
    List<Route> viewAllRoutesPageWise(Integer pageNumber,Integer numberOfRecords);
}
