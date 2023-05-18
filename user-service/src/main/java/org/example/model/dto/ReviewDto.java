package org.example.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReviewDto {
    private UUID id;
    private UUID productId;
    private String comment;
    private byte[] attachedFile;
    private LocalDateTime createDate;
    private UUID userId;
}
