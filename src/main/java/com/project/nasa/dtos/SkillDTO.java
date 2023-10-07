package com.project.nasa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SkillDTO {

    private Long id;

    private List<ProjectDTO> projectDTOS;

    private List<UserDTO> userDTOS;

    private String name;

}


