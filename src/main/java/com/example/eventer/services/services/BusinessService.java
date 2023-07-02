package com.example.eventer.services.services;

import com.example.eventer.dao.request.BusinessCreateRequest;
import com.example.eventer.entity.Business;

import java.util.List;
import java.util.Optional;

public interface BusinessService {

    Business addBusiness(BusinessCreateRequest request);

    List<Business> giveOwnersBusiness(Long ownersId);
}
