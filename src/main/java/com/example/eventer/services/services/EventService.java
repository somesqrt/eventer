package com.example.eventer.services.services;
import com.example.eventer.dao.request.EventCreateRequest;
import com.example.eventer.entity.Business;
import com.example.eventer.entity.Event;

import java.util.List;

public interface EventService {

    Event addEvent(EventCreateRequest request);

    List<Event> getEventForBusiness(Long businessID);
}
