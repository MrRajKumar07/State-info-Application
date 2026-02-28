package com.example.state_info.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.state_info.dto.StateDTO;
import com.example.state_info.dto.StateDetailsDTO;
import com.example.state_info.exception.StateNotFoundException;
import com.example.state_info.model.State;
import com.example.state_info.repository.StateDetailsRepository;
import com.example.state_info.repository.StateRepository;

@Service
public class StateServiceImp implements StateService {

    @Autowired
    private StateRepository stateRepo;

    @Autowired
    private StateDetailsRepository stateDetailsRepo;

    @Override
    public List<StateDTO> getAllStates() {
        return stateRepo.findAllWithDetails()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StateDTO getStateById(Long id) {
        State state = stateRepo.findById(id)
                .orElseThrow(() -> new StateNotFoundException("State not found with ID: " + id));
        
        return convertToDTO(state);
    }

    private StateDTO convertToDTO(State state) {
        StateDTO stateDto = new StateDTO();
        stateDto.setId(state.getId());
        stateDto.setStateName(state.getStateName());

        if (state.getStateDetails() != null) {
            StateDetailsDTO detailsDto = new StateDetailsDTO();
            detailsDto.setCapital(state.getStateDetails().getCapital());
            detailsDto.setPopulation(state.getStateDetails().getPopulation());
            detailsDto.setAbout(state.getStateDetails().getAbout());
            
            stateDto.setDetails(detailsDto);
        }
        
        return stateDto;
    }
}
