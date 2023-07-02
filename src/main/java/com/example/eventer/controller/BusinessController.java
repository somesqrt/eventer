package com.example.eventer.controller;

import com.example.eventer.dao.request.BusinessCreateRequest;
import com.example.eventer.entity.Business;
import com.example.eventer.services.services.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/business")
@RequiredArgsConstructor
public class BusinessController {
    private final BusinessService businessService;

    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<Business> saveBusiness(@RequestBody BusinessCreateRequest request) {
        return ResponseEntity.ok(businessService.addBusiness(request));
    }

    @GetMapping("/get")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER', 'EMPLOY')")
    public ResponseEntity<List<Business>> getBusiness(@RequestParam("owner") long owner) {
        return ResponseEntity.ok(businessService.giveOwnersBusiness(owner));
    }
}
