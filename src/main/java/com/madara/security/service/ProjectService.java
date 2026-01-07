package com.madara.security.service;

import com.madara.security.model.Project;
import com.madara.security.response.DTO.ProjectDTO;

import java.util.List;

public interface ProjectService {
    Project create(ProjectDTO projectDTO);
    Project update(ProjectDTO projectDTO, Long id);
    ProjectDTO getById(Long id);
    void delete(Long id);
    List<ProjectDTO> getAllProjects();
}
