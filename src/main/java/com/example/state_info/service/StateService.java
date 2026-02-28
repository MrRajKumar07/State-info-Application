package com.example.state_info.service;

import java.util.List;

import com.example.state_info.dto.StateDTO;

public interface StateService {
    List<StateDTO> getAllStates();
    StateDTO getStateById(Long id);
}
