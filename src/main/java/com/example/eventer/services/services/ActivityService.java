package com.example.eventer.services.services;

import com.example.eventer.dao.request.ActivityCreateRequest;
import com.example.eventer.entity.TypeOfActivity;

public interface ActivityService {

    TypeOfActivity addActivity(ActivityCreateRequest request);
}
