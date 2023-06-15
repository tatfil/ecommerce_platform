package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.entity.OrderItem;
import org.example.repository.OrderItemRepository;
import org.example.service.OrderItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public void deleteAllByOrderId(Long orderId) {
        orderItemRepository.deleteByOrderId(orderId);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderItem findById(Long orderItemId) {
        return orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new EntityNotFoundException("A nonexistent orderItemId was received"));
    }
}
