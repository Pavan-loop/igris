package com.madara.security.mapper;

import com.madara.security.model.Client;
import com.madara.security.response.DTO.ClientDTO;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client toEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        client.setPhoneNumber(clientDTO.getPhoneNumber());
        client.setAddress(clientDTO.getAddress());
        return client;
    }

    public Client toClientDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName(client.getName());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setPhoneNumber(client.getPhoneNumber());
        clientDTO.setAddress(client.getAddress());
        return client;
    }

    public void updateMapper(Client entity, ClientDTO dto) {
        entity.setName(dto.getName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        entity.setAddress(dto.getAddress());
    }
}
