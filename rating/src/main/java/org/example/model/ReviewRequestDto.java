package org.example.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewRequestDto {
    private Integer userId;
    private Integer itemId;
    private Integer starRating;
    private LocalDateTime created;
    private String review;
}
