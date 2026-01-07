package com.madara.security.mapper;

import com.madara.security.model.Client;
import com.madara.security.model.Project;
import com.madara.security.model.User;
import com.madara.security.model.project.Status;
import com.madara.security.response.DTO.ProjectDTO;

public class ProjectMapper {

    public Project toEntity(ProjectDTO dto, User manager, Client client, Status status) {
        Project project = new Project();
        project.setProjectName(dto.getProjectName());
        project.setSiteLocation(dto.getSiteLocation());
        project.setProjectType(dto.getProjectType());
        project.setStartDate(dto.getStartDate());
        project.setDueDate(dto.getDueDate());
        project.setMaterial(dto.getMaterial());
        project.setEstimatedCost(dto.getEstimatedCost());
        project.setStatus(status);
        project.setManager(manager);
        project.setClient(client);
        return project;
    }
}
