package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>, PagingAndSortingRepository<Admin, Integer> {

}
