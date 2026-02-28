package com.example.state_info.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.state_info.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
	@Query("SELECT s FROM State s LEFT JOIN FETCH s.stateDetails")
    List<State> findAllWithDetails();
}

