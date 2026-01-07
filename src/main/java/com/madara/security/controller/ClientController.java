package com.madara.security.controller;

import com.madara.security.model.Client;
import com.madara.security.response.DTO.ApiResponse;
import com.madara.security.response.DTO.ClientDTO;
import com.madara.security.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/client")
// TODO: Restructure this ApiResponse<> add custom contracture to reuse of the code
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Client>> createClient(
            @Valid @RequestBody ClientDTO clientDTO
            ) {
        Client client = clientService.create(clientDTO);
        ApiResponse<Client> response =
                ApiResponse.success(client, "User Created", HttpStatus.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<Client>> updateClient(
            @Valid @RequestBody ClientDTO clientDTO,
            @RequestParam Long id
    ) {
        Client client = clientService.update(clientDTO, id);
        ApiResponse<Client> response =
                ApiResponse.success(client, "User Updated Successfully", HttpStatus.ACCEPTED);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ClientDTO>> getClientById(
            @PathVariable Long id
    ) {
        ClientDTO client = clientService.selectClient(id);
        ApiResponse<ClientDTO> response =
                ApiResponse.success(client, "Client Found", HttpStatus.FOUND);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteClientById(
            @PathVariable Long id
    ) {
        clientService.delete(id);
        ApiResponse<Void> response =
                ApiResponse.success(null, "Client deleted", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ClientDTO>>> getAllClients() {
        List<ClientDTO> clients = clientService.getAllClient();
        ApiResponse<List<ClientDTO>> response =
                ApiResponse.success(clients, "List of Clients", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
