package com.example.eventer.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventCreateRequest {
    private String businessId;
    private Date startTime;
    private Date endTime;
    private String typeOfActivity;
    private String workerId;
    private String clientId;
}
