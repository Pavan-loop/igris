package com.madara.security.service.impl;

import com.madara.security.Exception.type.UserAlreadyExistException;
import com.madara.security.Exception.type.UserNotFoundException;
import com.madara.security.mapper.ClientMapper;
import com.madara.security.model.Client;
import com.madara.security.repository.ClientRepository;
import com.madara.security.response.DTO.ClientDTO;
import com.madara.security.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public Client create(ClientDTO dto) {
        if(clientRepository.existsByEmailOrPhoneNumber(
                dto.getEmail(),
                dto.getPhoneNumber()
        )) {
            throw new UserAlreadyExistException("User with same details already exists");
        }

        Client client = clientMapper.toEntity(dto);
        return clientRepository.save(client);
    }

    @Override
    public Client update(ClientDTO dto, Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));

        if (clientRepository.existsByEmailOrPhoneNumberAndIdNot(
                dto.getEmail(),
                dto.getPhoneNumber(),
                id
        )) {
            throw new UserAlreadyExistException("User With same details already exists");
        }

        clientMapper.updateMapper(client, dto);
        return clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
        clientRepository.delete(client);
    }

    @Override
    public Client selectClient(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    @Override
    public List<Client> getAllClient() {
        List<Client> clients = clientRepository.findAll();
        if (clients.isEmpty()) {
            throw new UserNotFoundException("You don't Have any clients");
        }
        return clients;
    }


}
