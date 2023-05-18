package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.repository.RatingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingRepository ratingRepository;

    @GetMapping("/testRating")
    public String testFeignRating(@PathVariable("id") String id) {
        return ratingRepository.getByUserId(UUID.fromString("1e1fb86e-b047-11ed-afa1-0242ac120002")).getReview();
    }

    @GetMapping("/testRatingMock")
    public String testFeignRatingMock() {
        return "5 stars";
    }
}
