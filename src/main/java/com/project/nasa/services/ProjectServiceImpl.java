package com.project.nasa.services;

import com.project.nasa.dtos.CategoryDTO;
import com.project.nasa.dtos.ProjectDTO;
import com.project.nasa.dtos.SkillDTO;
import com.project.nasa.dtos.UserDTO;
import com.project.nasa.models.Category;
import com.project.nasa.models.Project;
import com.project.nasa.models.Skill;
import com.project.nasa.models.User;
import com.project.nasa.repository.CategoryRepository;
import com.project.nasa.repository.ProjectRepository;
import com.project.nasa.repository.SkillRepository;
import com.project.nasa.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = modelMapper.map(projectDTO, Project.class);

        if (projectDTO.getSkillIds() != null && !projectDTO.getSkillIds().isEmpty()) {
            List<Skill> skills = skillRepository.findAllById(projectDTO.getSkillIds());
            project.setSkills((Set<Skill>) skills);
        }

        if (projectDTO.getCategoryIds() != null && !projectDTO.getCategoryIds().isEmpty()) {
            List<Category> categories = categoryRepository.findAllById(projectDTO.getCategoryIds());
            project.setCategories((Set<Category>) categories);
        }

        if (projectDTO.getUserIds() != null && !projectDTO.getUserIds().isEmpty()) {
            List<User> users = userRepository.findAllById(projectDTO.getUserIds());
            project.setUsers((Set<User>) users);
        }

        // Guarda el proyecto en la base de datos
        Project savedProject = projectRepository.save(project);
        return modelMapper.map(savedProject, ProjectDTO.class);
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found with id: " + id));
        return modelMapper.map(project, ProjectDTO.class);
    }

    @Override
    public ProjectDTO updateProject(Long id, ProjectDTO projectDTO) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found with id: " + id));

        project.setName(projectDTO.getName());

        if (projectDTO.getSkillIds() != null && !projectDTO.getSkillIds().isEmpty()) {
            List<Skill> skills = skillRepository.findAllById(projectDTO.getSkillIds());
            project.setSkills((Set<Skill>) skills);
        }

        if (projectDTO.getCategoryIds() != null && !projectDTO.getCategoryIds().isEmpty()) {
            List<Category> categories = categoryRepository.findAllById(projectDTO.getCategoryIds());
            project.setCategories((Set<Category>) categories);
        }

        if (projectDTO.getUserIds() != null && !projectDTO.getUserIds().isEmpty()) {
            List<User> users = userRepository.findAllById(projectDTO.getUserIds());
            project.setUsers((Set<User>) users);
        }

        Project updatedProject = projectRepository.save(project);
        return modelMapper.map(updatedProject, ProjectDTO.class);
    }

    @Override
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found with id: " + id));
        projectRepository.deleteById(id);
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projectList = projectRepository.findAll();
        return projectList.stream()
                .map(project -> modelMapper.map(project, ProjectDTO.class))
                .collect(Collectors.toList());
    }
}
