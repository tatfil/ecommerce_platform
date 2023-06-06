package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.Review;
import org.example.model.ReviewRequestDto;
import org.example.repository.ReviewRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository ratingRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public Review save(ReviewRequestDto ratingDto) {
        Review rating = new Review();
        rating.setUserId(ratingDto.getUserId());
        rating.setItemId(ratingDto.getItemId());
        rating.setStarRating(ratingDto.getStarRating());
        rating.setCreated(LocalDateTime.now());
        rating.setReview(ratingDto.getReview());

        return ratingRepository.insert(rating);
    }

    @Override
    public List<Review> getByUserId(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(Integer.valueOf(userId)));
        return mongoTemplate.find(query, Review.class);
    }

    @Override
    public Optional<Review> getReviewByItemId(String itemId) {
        return ratingRepository.findReviewByItemId(Integer.valueOf(itemId));
    }
}
