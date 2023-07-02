package com.example.eventer.controller;

import com.example.eventer.dao.request.BusinessCreateRequest;
import com.example.eventer.dao.request.EventCreateRequest;
import com.example.eventer.entity.Business;
import com.example.eventer.entity.Event;
import com.example.eventer.services.services.BusinessService;
import com.example.eventer.services.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER', 'EMPLOY')")
    public ResponseEntity<Event> saveEvent(@RequestBody EventCreateRequest request) {
        return ResponseEntity.ok(eventService.addEvent(request));
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER', 'EMPLOY')")
    public ResponseEntity<List<Event>> getAllEvents(@RequestParam("businessId") long businessId) {
        return ResponseEntity.ok(eventService.getEventForBusiness(businessId));
    }
}
