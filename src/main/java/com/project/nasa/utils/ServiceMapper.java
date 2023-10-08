package com.project.nasa.utils;

import com.project.nasa.dtos.CategoryDTO;
import com.project.nasa.dtos.ProjectDTO;
import com.project.nasa.dtos.SkillDTO;
import com.project.nasa.dtos.UserDTO;
import com.project.nasa.models.Category;
import com.project.nasa.models.Project;
import com.project.nasa.models.Skill;
import com.project.nasa.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceMapper {

    public ProjectDTO mapToProjectDTO(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setTitle(project.getTitle());
        projectDTO.setImg(project.getImg());
        projectDTO.setUrl(project.getUrl());
        projectDTO.setDescription(project.getDescription());
        projectDTO.setProject_goals(project.getProject_goals());
        projectDTO.setEmail(project.getEmail());
        projectDTO.setStatus(project.getStatus());
        projectDTO.setStart_date(project.getStart_date());
        projectDTO.setScistarter(project.getScistarter());
        projectDTO.setGeographic_scope(project.getGeographic_scope());


        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category category : project.getCategories()) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(category.getId());
            categoryDTO.setName(category.getName());
            categoryDTOS.add(categoryDTO);
        }

        List<SkillDTO> skillDTOS = new ArrayList<>();
        for (Skill skill : project.getSkills()) {
            SkillDTO skillDTO = new SkillDTO();
            skillDTO.setId(skill.getId());
            skillDTO.setName(skill.getName());
            skillDTOS.add(skillDTO);
        }

        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : project.getUsers()) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTOS.add(userDTO);
        }

        projectDTO.setCategoryDTOS(categoryDTOS);
        projectDTO.setUserDTOS(userDTOS);
        projectDTO.setSkillDTOS(skillDTOS);

        return projectDTO;
    }

    public UserDTO mapToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());

        List<SkillDTO> skillDTOS = new ArrayList<>();
        for (Skill skill : user.getSkills()) {
            SkillDTO skillDTO = new SkillDTO();
            skillDTO.setId(skill.getId());
            skillDTO.setName(skill.getName());
            skillDTOS.add(skillDTO);
        }

        List<ProjectDTO> projectDTOS = new ArrayList<>();
        for (Project project : user.getProjects()) {
            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setId(project.getId());
            projectDTO.setTitle(project.getTitle());

            List<CategoryDTO> categoryDTOS = new ArrayList<>();
            for (Category category : project.getCategories()) {
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setId(category.getId());
                categoryDTO.setName(category.getName());
                categoryDTOS.add(categoryDTO);
            }
            projectDTO.setCategoryDTOS(categoryDTOS);

            List<SkillDTO> projectSkillDTOS = new ArrayList<>();
            for (Skill projectSkill : project.getSkills()) {
                SkillDTO projectSkillDTO = new SkillDTO();
                projectSkillDTO.setId(projectSkill.getId());
                projectSkillDTO.setName(projectSkill.getName());
                projectSkillDTOS.add(projectSkillDTO);
            }
            projectDTO.setSkillDTOS(projectSkillDTOS);

            projectDTOS.add(projectDTO);
        }

        userDTO.setProjectDTOS(projectDTOS);
        userDTO.setSkillDTOS(skillDTOS);

        return userDTO;
    }
}

