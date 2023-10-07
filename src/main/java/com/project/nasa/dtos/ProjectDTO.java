package com.project.nasa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private Long id;

    private List<Long> categoryIds;
    private List<CategoryDTO> categoryDTOS;

    private List<Long> skillIds;
    private List<SkillDTO> skillDTOS;

    private List<Long> userIds;
    private List<UserDTO> userDTOS;

    private String name;
}
