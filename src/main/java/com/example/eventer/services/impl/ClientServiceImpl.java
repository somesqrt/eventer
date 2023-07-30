package com.example.eventer.services.impl;

import com.example.eventer.dao.request.ClientCreateRequest;
import com.example.eventer.entity.Client;
import com.example.eventer.entity.User;
import com.example.eventer.repos.BusinessRepository;
import com.example.eventer.repos.ClientRepository;
import com.example.eventer.services.services.ClientService;
import com.example.eventer.services.services.IdGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final IdGeneratorService idGeneratorService;
    private final BusinessRepository businessRepository;

    @Override
    public Client addClient(ClientCreateRequest request) {
        var existingClient = clientRepository.findByClientId(idGeneratorService.giveNextId("event"));
        if (existingClient.isPresent()) {
            throw new IllegalArgumentException("Event with the same ID already exists.");
        }

        var client = Client.builder()
                .clientId(idGeneratorService.generateNextId("client"))
                .businessId(request.getBusinessId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .build();

        clientRepository.save(client);
        return client;
    }

    @Override
    public List<Client> getClientsForBusiness(String businessId) {
        var existingBusiness = businessRepository.findByBusinessID(Long.parseLong(businessId));
        if (existingBusiness.isEmpty()) {
            throw new IllegalArgumentException("Business dosent exist");
        }
        List<Client> userList = new ArrayList<>();
        userList = clientRepository.findByBusinessId(Long.parseLong(businessId));
        System.out.println(userList.toString());
        //System.out.println(clients.toString());

        return userList;
    }
}
