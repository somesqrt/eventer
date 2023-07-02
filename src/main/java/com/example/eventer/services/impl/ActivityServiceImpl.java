package com.example.eventer.services.impl;

import com.example.eventer.dao.request.ActivityCreateRequest;
import com.example.eventer.entity.Business;
import com.example.eventer.entity.TypeOfActivity;
import com.example.eventer.repos.ActivityRepository;
import com.example.eventer.repos.BusinessRepository;
import com.example.eventer.services.services.ActivityService;
import com.example.eventer.services.services.IdGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;
    private final BusinessRepository businessRepository;
    @Override
    public TypeOfActivity addActivity(ActivityCreateRequest request) {
        var existingActivity = activityRepository.findByBusinessIDAndNameOfActivity(request.getBusinessID(), request.getNameOfActivity());
        if (existingActivity.isPresent()) {
            throw new IllegalArgumentException("Activity with the same name for this business already exists.");
        }

        var existingBusiness = businessRepository.findByBusinessID(request.getBusinessID());
        if(existingBusiness.isPresent()){
            var activity = TypeOfActivity.builder()
                    .businessID(request.getBusinessID())
                    .nameOfActivity(request.getNameOfActivity())
                    .duration(request.getDuration())
                    .price(request.getPrice())
                    .build();

            activityRepository.save(activity);
            return activity;
        }else{
            throw new IllegalArgumentException("Business with this ID does not exist.");
        }
    }
}
