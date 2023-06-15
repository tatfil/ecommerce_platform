package org.example.service.impl;

import org.example.model.dto.OrderCreationDto;
import org.example.model.entity.Order;
import org.example.model.entity.OrderItem;
import org.example.model.entity.User;
import org.example.model.enums.AccountStatus;
import org.example.model.enums.OrderStatus;
import org.example.repository.OrderRepository;
import org.example.repository.UserRepository;
import org.example.service.OrderItemService;
import org.example.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    private User requester = new User(1L, "Requester", "requester@mail.com", "password", new BigDecimal(1000), AccountStatus.ACTIVE);

    private User responsible = new User(2L, "Responsible", "responsible@mail.com", "password", new BigDecimal(1000), AccountStatus.ACTIVE);
    private byte[] attachedFile = {};

    private OrderItem orderItem = new OrderItem(1L, new Order(), 1L, 1L, 1L, "", attachedFile);
    private Order order = new Order(1L, new HashSet<>(), requester, responsible, OrderStatus.IN_PROGRESS, LocalDateTime.now(), attachedFile, "", 1);

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private OrderItemService orderItemService;

    private OrderService orderService;

    @BeforeEach
    void setUp(){
         orderService = new OrderServiceImpl(orderRepository, userRepository, orderItemService);
    }

    @Test
    @Disabled
    void getOrderDtoByOrderId() {
    }

    @Test
    @Disabled
    void willNotUpdateOrderWhenNotExist() {
        OrderCreationDto orderCreationDto = new OrderCreationDto(responsible.getId(), "");

        assertThatThrownBy(() -> orderService.updateOrder(orderCreationDto, 11L))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining("Cannot find order with id = %d ", 11L);
        verify(orderRepository, never()).save(any());
    }

    @Test
    @Disabled
    void canAddOrder() {
        //when
        orderRepository.save(order);

        //then
        ArgumentCaptor<Order> orderArgumentCaptor = ArgumentCaptor.forClass(Order.class);
        verify(orderRepository).save(orderArgumentCaptor.capture());

        Order capturedOrder = orderArgumentCaptor.getValue();
        assertThat(capturedOrder).isEqualTo(order);

    }

    @Test
    void canGetAll() {
        //when
        orderService.getAll();

        //then
        verify(orderRepository).findAll();
    }

    @Test
    void willThrowWhenOrderDoesNotExist() {
        assertThatThrownBy(() -> orderService.findById(11L))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining("Cannot find order with id = %d ", 11L);
    }

}