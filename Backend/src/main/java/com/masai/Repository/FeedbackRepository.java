package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.masai.models.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>, PagingAndSortingRepository<Feedback, Integer> {
    Page<Feedback> findAll(Pageable pageable);
}
