package org.example.repository;

import org.example.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> getByUserId(Integer integer);

    Optional<Review> findReviewByItemId(Integer itemId);


}
