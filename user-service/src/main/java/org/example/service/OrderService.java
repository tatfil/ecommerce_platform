package org.example.service;

import org.example.model.dto.OrderCreationDto;
import org.example.model.dto.OrderDTO;

public interface OrderService {
    OrderDTO getOrderDtoByOrderId(long parseLong);

    OrderDTO updateOrder(OrderCreationDto orderCreationDto, long id);

    OrderDTO create(OrderCreationDto orderDTO);
}
