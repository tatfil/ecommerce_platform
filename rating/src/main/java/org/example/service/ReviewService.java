package org.example.service;

import org.example.model.Review;
import org.example.model.ReviewRequestDto;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Review save(ReviewRequestDto ratingDto);

    List<Review> getByUserId(String string);

    Optional<Review> getReviewByItemId(String itemId);
}
