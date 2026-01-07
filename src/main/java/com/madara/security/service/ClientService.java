package com.madara.security.service;


import com.madara.security.model.Client;
import com.madara.security.response.DTO.ApiResponse;
import com.madara.security.response.DTO.ClientDTO;

import java.util.List;

public interface ClientService {
    Client create(ClientDTO client);
    Client update(ClientDTO client, Long id);
    void delete(Long id);
    ClientDTO selectClient(Long id);
    List<ClientDTO> getAllClient();
}
