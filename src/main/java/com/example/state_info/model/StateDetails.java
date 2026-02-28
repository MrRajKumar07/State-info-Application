package com.example.state_info.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "state_details")
public class StateDetails {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Long id;
    private Long population;
    private String capital;
    private String about;

    @OneToOne
    @JoinColumn(name = "state_id")
    private State state;
}
