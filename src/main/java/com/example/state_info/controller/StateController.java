package com.example.state_info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // Added missing import
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.state_info.dto.StateDTO;
import com.example.state_info.service.StateService;

@RestController
@RequestMapping("/api/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public ResponseEntity<List<StateDTO>> getAll() {
        List<StateDTO> states = stateService.getAllStates();
        return new ResponseEntity<>(states, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<StateDTO> getById(@PathVariable("id") Long id) {
        StateDTO stateDto = stateService.getStateById(id);
        return new ResponseEntity<>(stateDto, HttpStatus.OK);
    }
}