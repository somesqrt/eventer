package com.example.eventer.controller;

import com.example.eventer.dao.request.ActivityCreateRequest;
import com.example.eventer.entity.TypeOfActivity;
import com.example.eventer.services.services.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/activity")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<TypeOfActivity> saveActivity(@RequestBody ActivityCreateRequest request) {
        return ResponseEntity.ok(activityService.addActivity(request));
    }
}
