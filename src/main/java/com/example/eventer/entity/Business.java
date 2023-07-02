package com.example.eventer.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Document(collection = "business")
public class Business {
    @Id
    private Long businessID;
    private String name;
    private String owner;
    private String teamID;
}
