package com.example.eventer.controller;

import com.example.eventer.dao.request.BusinessCreateRequest;
import com.example.eventer.dao.request.ClientCreateRequest;
import com.example.eventer.entity.Business;
import com.example.eventer.entity.Client;
import com.example.eventer.services.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<Client> saveClient(@RequestBody ClientCreateRequest request) {
        return ResponseEntity.ok(clientService.addClient(request));
    }
}
