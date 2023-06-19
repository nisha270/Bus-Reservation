package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.masai.models.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer>,PagingAndSortingRepository<Bus, Integer> {
    
	@Query("Select b from Bus b where b.busType = ?1 ")
	List<Bus> getBusByBusType(String b);
	
	
}
