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
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Client>> createClient(
            @Valid @RequestBody ClientDTO clientDTO
            ) {
        Client client = clientService.create(clientDTO);
        ApiResponse<Client> response = ApiResponse.<Client>builder()
                .success(true)
                .status(HttpStatus.CREATED)
                .message("User Created")
                .data(client)
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<Client>> updateClient(
            @Valid @RequestBody ClientDTO clientDTO,
            @RequestParam Long id
    ) {
        Client client = clientService.update(clientDTO, id);
        ApiResponse<Client> response = ApiResponse.<Client>builder()
                .success(true)
                .status(HttpStatus.ACCEPTED)
                .message("User Updated Successfully")
                .data(client)
                .build();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Client>> getClientById(
            @PathVariable Long id
    ) {
        Client client = clientService.selectClient(id);
        ApiResponse<Client> response = ApiResponse.<Client>builder()
                .success(true)
                .status(HttpStatus.FOUND)
                .message("Client Found")
                .data(client)
                .build();
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteClientById(
            @PathVariable Long id
    ) {
        clientService.delete(id);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Client deleted")
                .data(null)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Client>>> getAllClients() {
        List<Client> clients = clientService.getAllClient();
        ApiResponse<List<Client>> response = ApiResponse.<List<Client>>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("List of Clients")
                .data(clients)
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
