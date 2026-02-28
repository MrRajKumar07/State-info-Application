package com.example.state_info.dto;

import lombok.Data;

@Data
public class StateDTO {
    private Long id;
    private String stateName;
    private StateDetailsDTO details;
}
