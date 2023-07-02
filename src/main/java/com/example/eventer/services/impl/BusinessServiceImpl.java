package com.example.eventer.services.impl;

import com.example.eventer.dao.request.BusinessCreateRequest;
import com.example.eventer.entity.Business;
import com.example.eventer.repos.BusinessRepository;
import com.example.eventer.repos.TeamRepository;
import com.example.eventer.repos.UserRepository;
import com.example.eventer.services.services.BusinessService;
import com.example.eventer.services.services.IdGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements BusinessService {
    private final BusinessRepository businessRepository;
    private final IdGeneratorService idGeneratorService;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    @Override
    public Business addBusiness(BusinessCreateRequest request) {
        var existingBusiness = businessRepository.findByName(request.getName());
        if (existingBusiness.isPresent()) {
            throw new IllegalArgumentException("Business with the same email already exists.");
        }

        var existingOwner = userRepository.findByUserId(Long.parseLong(request.getOwner()));
        var existingTeam = teamRepository.findByTeamID(Long.parseLong(request.getTeamID()));
        if(existingOwner.isPresent() && existingTeam.isPresent()){
            var business = Business.builder()
                    .businessID(idGeneratorService.generateNextId("business"))
                    .name(request.getName())
                    .owner(request.getOwner())
                    .teamID(request.getTeamID())
                    .build();

            businessRepository.save(business);
            return business;
        }else{
            throw new IllegalArgumentException("Owner does not exist.");
        }
    }

    @Override
    public List<Business> giveOwnersBusiness(Long ownersId) {

        var existingOwner = userRepository.findByUserId(ownersId);
        if(existingOwner.isEmpty()){
            throw new IllegalArgumentException("Owner does not exist.");
        }

        var existingBusiness = businessRepository.findByOwner(String.valueOf(ownersId));
        return existingBusiness;
    }
}
