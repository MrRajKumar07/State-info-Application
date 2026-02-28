package com.example.state_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.state_info.model.StateDetails;

@Repository
public interface StateDetailsRepository extends JpaRepository<StateDetails, Long> {
	
}
