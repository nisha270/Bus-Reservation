package com.masai.Services;

import java.util.List;

import com.masai.models.Route;

public interface RouteService {
    Route addRoute(Route route);
    Route updateRoute(Route route);
    Route deleteRoute(int routeId);
    Route viewRoute(int routeId);
    List<Route> viewAllRoutes();
}
