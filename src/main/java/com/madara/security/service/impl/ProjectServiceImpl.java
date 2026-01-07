package com.madara.security.service.impl;

import com.madara.security.Exception.type.UserNotFoundException;
import com.madara.security.mapper.ProjectMapper;
import com.madara.security.model.Client;
import com.madara.security.model.Project;
import com.madara.security.model.User;
import com.madara.security.model.project.Status;
import com.madara.security.repository.ClientRepository;
import com.madara.security.repository.ProjectRepository;
import com.madara.security.repository.UserRepository;
import com.madara.security.response.DTO.ProjectDTO;
import com.madara.security.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;

    @Override
    public Project create(ProjectDTO projectDTO) {
        if (!clientRepository.existsById(projectDTO.getClientId())) {
            throw new UserNotFoundException("Client with id: " + projectDTO.getClientId() + "not found");

        }
        User manager = userRepository.getReferenceById(projectDTO.getManagerId());
        Client client = clientRepository.getReferenceById(projectDTO.getClientId());
        Project project = projectMapper.toEntity(projectDTO, manager, client, Status.TAKEN);
        return null;
    }

    @Override
    public Project update(ProjectDTO projectDTO, Long id) {
        return null;
    }

    @Override
    public ProjectDTO getById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return List.of();
    }
}
