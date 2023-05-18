package org.example.service;

import org.example.model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@FeignClient("ratings-service")
public interface RatingFeignClient {
    @GetMapping("/test")
    public Rating getRatingTest(UUID uuid);

}
