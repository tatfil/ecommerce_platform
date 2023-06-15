package org.example.service.impl;

import org.apache.catalina.mapper.Mapper;
import org.example.model.dto.OrderCreationDto;
import org.example.model.dto.OrderDTO;
import org.example.model.entity.Order;
import org.example.model.entity.User;
import org.example.repository.OrderRepository;
import org.example.repository.UserRepository;
import org.example.service.OrderItemService;
import org.example.service.OrderService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderItemService orderItemService;
    @Override
    public OrderDTO getOrderDtoByOrderId(long parseLong) {
        return null;
    }

    @Transactional
    @Override
    public OrderDTO updateOrder(OrderCreationDto orderCreationDto, long id) {

        Order order = findById(id);
        orderItemService.deleteAllByOrderId(order.getId());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Order detachedOrder = mapper.map(orderCreationDto, Order.class);

        detachedOrder.setId(order.getId());
        detachedOrder.setItemsCount(order.getItemsCount());

        Order orderResp = orderRepository.save(detachedOrder);
        return mapper.map(orderResp, OrderDTO.class);
    }

    @Transactional
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

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Cannot find order with id = %d ", id)));
    }
}