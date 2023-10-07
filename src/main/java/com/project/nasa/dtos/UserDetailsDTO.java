package com.project.nasa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDTO {

        private Long id;

        private String username;

        private String name;

        private String lastName;

        private String phone;

        private String email;

        private List<SkillDTO> skillDTOS;

        private List<ProjectDTO> projectDTOS;

}
