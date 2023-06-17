package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.masai.models.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer>,PagingAndSortingRepository<Bus, Integer> {
    Page<Bus> findAll(Pageable pageable);
    List<Bus> findByBusType(String busType, Pageable pageable);
}
