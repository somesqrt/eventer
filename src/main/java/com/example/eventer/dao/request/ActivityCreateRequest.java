package com.example.eventer.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityCreateRequest {
    private Long businessID;
    private String nameOfActivity;
    private String duration;
    private String price;
}
