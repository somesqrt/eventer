package com.example.eventer.services.services;

import com.example.eventer.dao.request.ClientCreateRequest;
import com.example.eventer.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client addClient(ClientCreateRequest request);

    List<Client> getClientsForBusiness(String businessId);
}
