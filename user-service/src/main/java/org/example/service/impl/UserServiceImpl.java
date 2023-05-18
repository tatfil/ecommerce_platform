package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.service.RatingFeignClient;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final RatingFeignClient ratingFeignClient;
    public String getRating(){
        return ratingFeignClient.getRating();
    }
}
