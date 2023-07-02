package com.example.eventer.services.impl;

import com.example.eventer.dao.request.EventCreateRequest;
import com.example.eventer.entity.Business;
import com.example.eventer.entity.Event;
import com.example.eventer.repos.BusinessRepository;
import com.example.eventer.repos.EventRepository;
import com.example.eventer.services.services.EventService;
import com.example.eventer.services.services.IdGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final BusinessRepository businessRepository;
    private final IdGeneratorService idGeneratorService;
    @Override
    public Event addEvent(EventCreateRequest request) {
        var existingEvent = eventRepository.findByEventID(idGeneratorService.giveNextId("event"));
        if (existingEvent.isPresent()) {
            throw new IllegalArgumentException("Event with the same ID already exists.");
        }

        var existingBusiness = businessRepository.findByBusinessID(Long.parseLong(request.getBusinessId()));
        if(existingBusiness.isPresent()){
            var event = Event.builder()
                    .eventID(idGeneratorService.generateNextId("event"))
                    .businessID(request.getBusinessId())
                    .startTime(request.getStartTime())
                    .endTime(request.getEndTime())
                    .typeOfActivity(request.getTypeOfActivity())
                    .assignedWorker(request.getAssignedWorker())
                    .clientId(request.getClientId())
                    .build();

            eventRepository.save(event);
            return event;
        }else{
            throw new IllegalArgumentException("Business with this ID doesnt exists.");
        }
    }

    @Override
    public List<Event> getEventForBusiness(Long businessID) {

        var existingBusiness = businessRepository.findByBusinessID(businessID);
        if(existingBusiness.isEmpty()){
            throw new IllegalArgumentException("Business with this ID doesnt exists.");
        }

        var events = eventRepository.findByBusinessID(String.valueOf(businessID));
        System.out.println(Arrays.toString(events.toArray()));
        return events;
    }
}
