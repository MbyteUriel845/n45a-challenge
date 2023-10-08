package com.project.nasa.web.controllers;

import com.project.nasa.dtos.*;
import com.project.nasa.models.Category;
import com.project.nasa.models.Project;
import com.project.nasa.repository.CategoryRepository;
import com.project.nasa.repository.ProjectRepository;
import com.project.nasa.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping()
    public ResponseEntity<Page<ProjectDTO>> getAllProjects(@RequestParam(defaultValue = "0") int pageNumber,
                                                           @RequestParam(defaultValue = "10") int pageSize,
                                                           @RequestParam(defaultValue = "id") String sortBy) {
        Page<ProjectDTO> projects = projectService.getAllProjects(pageNumber, pageSize, sortBy);
        return ResponseEntity.ok(projects);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id) {
        ProjectDTO projectDTO = projectService.getProjectById(id);
        return new ResponseEntity<>(projectDTO, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<List<Project>> saveProjectsFromURL(@RequestParam (name = "url") String url) {
        List<Project> projectDataList = projectService.saveProjectFromURL(url);

        List<Project> projects = new ArrayList<>();
        for (Project projectData : projectDataList) {
            Project project = new Project();
            project.setTitle(projectData.getTitle());
            project.setDescription(projectData.getDescription());
            project.setUrl(projectData.getUrl());
            project.setStatus(projectData.getStatus());
            project.setEmail(projectData.getEmail());
            project.setStart_date(projectData.getStart_date());
            project.setScistarter(projectData.getScistarter());
            project.setProject_goals(projectData.getProject_goals());
            project.setGeographic_scope(projectData.getGeographic_scope());

            List<Category> categories = new ArrayList<>();
            for (Category categoryData : projectData.getCategories()) {
                Category category = new Category();
                category.setName(categoryData.getName());
                categories.add(category);
            }
            project.setCategories(categories);
            projects.add(project);
        }
        projectRepository.saveAll(projects);
        return new ResponseEntity<>(projects, HttpStatus.CREATED);
    }
}
