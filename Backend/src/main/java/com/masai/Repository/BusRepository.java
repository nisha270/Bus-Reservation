package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer>,PagingAndSortingRepository<Bus, Integer> {

}
