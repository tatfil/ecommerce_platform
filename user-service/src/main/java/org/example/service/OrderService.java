package org.example.service;

import org.example.model.dto.OrderCreationDto;
import org.example.model.dto.OrderDTO;
import org.example.model.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    OrderDTO getOrderDtoByOrderId(long parseLong);

    OrderDTO updateOrder(OrderCreationDto orderCreationDto, long id);

    OrderDTO create(OrderCreationDto orderDTO);

    List<Order> getAll();

    Order findById(Long id);
}
