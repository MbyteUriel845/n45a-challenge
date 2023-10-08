package com.project.nasa.services;

import com.project.nasa.dtos.ProjectDTO;
import com.project.nasa.models.Project;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProjectService {
    ProjectDTO getProjectById(Long id);

    Page<ProjectDTO> getAllProjects(int pageNumber, int pageSize, String sortBy);


    List<Project> saveProjectFromURL(String url);

}
