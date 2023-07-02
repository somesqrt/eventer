package com.example.eventer.services.services;

public interface IdGeneratorService {
    long generateNextId(String sequenceName);

    long giveNextId(String sequenceName);
}
