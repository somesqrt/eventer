package com.example.eventer.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Document(collection = "events")
public class Event {
    @Id
    private Long eventID;
    private String businessID;
    private Date startTime;
    private Date endTime;
    private String typeOfActivity;
    private String workerId;
    private String clientId;
}
