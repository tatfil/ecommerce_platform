package org.example.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;



@Data
@RequiredArgsConstructor
@Document
public class Review {

    @Id
    private String id;
    private Integer userId;
    private Integer itemId;
    private Integer starRating;
    private LocalDateTime created;
    private String review;
}
