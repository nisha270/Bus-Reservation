package com.masai.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>,PagingAndSortingRepository<Reservation, Integer> {
    Page<Reservation> findAll(Pageable pageable);
    List<Reservation> findAllByOrderByReservationDateDesc(Pageable pageable);
}
