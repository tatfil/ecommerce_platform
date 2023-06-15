package org.example.service;

import org.example.model.entity.OrderItem;

public interface OrderItemService {
    void deleteAllByOrderId(Long orderId);

    OrderItem findById(Long orderItemId);
}
