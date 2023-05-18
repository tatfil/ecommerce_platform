package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.OrderDTO;
import org.example.model.dto.OrderCreationDto;
import org.example.service.RatingFeignClient;
import org.example.service.OrderService;

import org.example.service.UserService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final RatingFeignClient itemFeignClient;

    private final UserService userService;

    private final Environment environment;

    @GetMapping("/test")
    public String testFeign(@PathVariable("id") String id) {
        return itemFeignClient.getItemTest(UUID.fromString("1e1fb86e-b047-11ed-afa1-0242ac120002")).getName();
    }

    @GetMapping("/testProduct")
    public String testFeignProduct(@PathVariable("id") String id) {
        return itemFeignClient.getProductTest(UUID.fromString("1e1fb86e-b047-11ed-afa1-0242ac120002")).getName();
    }

    @GetMapping("/status/check")
    public String status(){
        return "PORT:  " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderCreationDto orderDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(orderDTO));
    }

    @GetMapping("/testfeign")
    public String testFeign(){
        return "Answer from rating service:  " + userService.getRating();
    }
}
