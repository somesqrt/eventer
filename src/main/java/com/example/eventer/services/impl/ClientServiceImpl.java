package com.example.eventer.services.impl;

import com.example.eventer.dao.request.ClientCreateRequest;
import com.example.eventer.entity.Client;
import com.example.eventer.entity.Team;
import com.example.eventer.repos.ClientRepository;
import com.example.eventer.repos.TeamRepository;
import com.example.eventer.services.services.ClientService;
import com.example.eventer.services.services.IdGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final IdGeneratorService idGeneratorService;
    @Override
    public Client addClient(ClientCreateRequest request) {
        var existingClient = clientRepository.findByClientId(idGeneratorService.giveNextId("event"));
        if (existingClient.isPresent()) {
            throw new IllegalArgumentException("Event with the same ID already exists.");
        }

        var client = Client.builder()
                .clientId(idGeneratorService.generateNextId("client"))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .build();

        clientRepository.save(client);
        return client;
    }
}
