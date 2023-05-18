package org.example.model.dto;

import java.time.LocalDateTime;

public class ReviewDto {
    private Long id;
    private Long productId;
    private String comment;
    private byte[] attachedFile;
    private LocalDateTime createDate;
    private Long userId;
}
