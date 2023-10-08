package com.project.nasa.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private List<Long> skillIds;

    private List<SkillDTO> skillDTOS;

    @JsonIgnore
    private List<Long> projectIds;

    private List<ProjectDTO> projectDTOS;

}
