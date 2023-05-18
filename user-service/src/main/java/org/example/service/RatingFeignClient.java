package org.example.service;
import org.example.model.entity.ItemTest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient("rating-service")
public interface RatingFeignClient {
//    @PostMapping("/reviews/")
//    OrderDTO addReview(String itemId, ReviewDto review);

//    @PostMapping("product")
//    String setOrder(String itemId, OrderDTO orderDTO);

    @GetMapping("/product/test")
    ItemTest getItemTest(UUID itemId);

    @GetMapping("/product/{id}")
    ItemTest getProductTest(@PathVariable("id") UUID itemId);

    @GetMapping(value = "ratings/testRatingMock")
    public String getRating();
}
