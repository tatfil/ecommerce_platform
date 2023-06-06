package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.example.model.Review;
import org.example.model.ReviewRequestDto;
import org.example.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

//    @GetMapping("/testRating")
//    public String testFeignRating(@PathVariable("id") String id) {
//        return ratingRepository.getByUserId(UUID.fromString("1e1fb86e-b047-11ed-afa1-0242ac120002")).getReview();
//    }

    @GetMapping("/testRatingMock")
    public String testFeignRatingMock() {
        return "5 stars";
    }

    @Operation(summary = "Create new review")
    @ApiResponse(responseCode = "200", description = "The review was created successfully")
    @ApiResponse(responseCode = "403", description = "Your role doesn't have access")
    @ApiResponse(responseCode = "400", description = "Incorrect data transmitted")
    @PostMapping("/")
    public ResponseEntity<Review> addReview(@Valid @RequestBody ReviewRequestDto ratingDto) {
        Review review = reviewService.save(ratingDto);
        return ResponseEntity.ok().body(review);
    }

    @GetMapping("/{id}")
    public List<Review> getReviewByUser(@PathVariable("id") String id) {
        return reviewService.getByUserId(id);
    }

}
