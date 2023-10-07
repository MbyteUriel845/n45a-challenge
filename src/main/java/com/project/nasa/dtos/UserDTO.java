package com.project.nasa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String username;

    private List<SkillDTO> skillDTOS;

    private List<ProjectDTO> projectDTOS;

}
