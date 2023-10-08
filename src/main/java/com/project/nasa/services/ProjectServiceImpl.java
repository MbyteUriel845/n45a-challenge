package com.project.nasa.services;

import com.project.nasa.dtos.*;
import com.project.nasa.models.Project;
import com.project.nasa.repository.ProjectRepository;
import com.project.nasa.utils.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public ProjectDTO getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found with id: " + id));
        return serviceMapper.mapToProjectDTO(project);
    }


    @Override
    public Page<ProjectDTO> getAllProjects(int pageNumber, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Page<Project> projects = projectRepository.findAll(pageable);
        return projects.map(serviceMapper::mapToProjectDTO);
    }

    @Override
    public List<Project> saveProjectFromURL(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Project[]> response = restTemplate.getForEntity(url, Project[].class);
        return Arrays.asList(response.getBody());
    }
}

