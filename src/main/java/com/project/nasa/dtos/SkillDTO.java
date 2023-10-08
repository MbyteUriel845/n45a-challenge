package com.project.nasa.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SkillDTO {

    private Long id;

    @JsonIgnore
    private List<ProjectDTO> projectDTOS;

    private List<UserDTO> userDTOS;

    private String name;

    private Long experience;

}


