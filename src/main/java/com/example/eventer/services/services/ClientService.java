package com.example.eventer.services.services;

import com.example.eventer.dao.request.ClientCreateRequest;
import com.example.eventer.entity.Client;

public interface ClientService {

    Client addClient(ClientCreateRequest request);
}
