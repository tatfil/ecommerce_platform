package org.example.service.impl;

import org.apache.catalina.mapper.Mapper;
import org.example.model.dto.OrderCreationDto;
import org.example.model.dto.OrderDTO;
import org.example.model.entity.Order;
import org.example.model.entity.User;
import org.example.repository.OrderRepository;
import org.example.repository.UserRepository;
import org.example.service.OrderService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    @Override
    public OrderDTO getOrderDtoByOrderId(long parseLong) {
        return null;
    }

    @Override
    public OrderDTO updateOrder(OrderCreationDto orderCreationDto, long id) {
        return null;
    }

    @Override
    public OrderDTO create(OrderCreationDto orderDTO) {

        Order order = Order.builder()
                .responsible(userRepository.getById(orderDTO.getResponsibleId()))
                .build();
        Order orderResp = orderRepository.save(order);
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return mapper.map(orderResp, OrderDTO.class);
    }
}