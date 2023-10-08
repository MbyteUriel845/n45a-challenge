package com.project.nasa.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private List<CategoryDTO> categoryDTOS;

    private List<SkillDTO> skillDTOS;

    private List<UserDTO> userDTOS;

    private String title;

    private String img;

    private String url;

    private String description;

    private String project_goals;

    private String email;

    private String status;

    private String start_date;

    private String scistarter;

    private String geographic_scope;


}
