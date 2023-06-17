package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.masai.models.Route;

public interface RouteRepository extends JpaRepository<Route, Integer>, PagingAndSortingRepository<Route, Integer> {
    
}
