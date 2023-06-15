package org.example.repository;

import org.example.model.entity.Order;
import org.example.model.entity.OrderItem;
import org.example.model.entity.User;
import org.example.model.enums.AccountStatus;
import org.example.model.enums.OrderStatus;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrderRepositoryTest {
    private User requester = new User(1L, "Requester", "requester@mail.com", "password", new BigDecimal(1000), AccountStatus.ACTIVE);

    private User responsible = new User(2L, "Responsible", "responsible@mail.com", "password", new BigDecimal(1000), AccountStatus.ACTIVE);
    private byte[] attachedFile = {};

    private OrderItem orderItem = new OrderItem(1L, new Order(), 1L, 1L, 1L, "", attachedFile);
    private Order order = new Order(1L, new HashSet<>(), requester, responsible, OrderStatus.IN_PROGRESS, LocalDateTime.now(), attachedFile, "", 1);
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;


    @BeforeEach
    public void setUp() {

        userRepository.save(requester);
        userRepository.save(responsible);
        orderRepository.save(order);
    }

    @AfterEach
    public void tearDown(){
        userRepository.deleteAll();
        orderRepository.deleteAll();
    }


    @Test
    public void itShouldCheckIfStatusWasUpdated(){
        //when
        orderRepository.updateOrderStatus(order.getId(), OrderStatus.APPROVED);

        //then
        assertThat(orderRepository.findById(order.getId()).orElseThrow().getStatus()).isEqualTo(OrderStatus.APPROVED);
    }

    @Test
    public void itShouldCheckIfStatusWasNotUpdated(){

        assertThat(orderRepository.findById(order.getId()).orElseThrow().getStatus()).isNotEqualTo(OrderStatus.APPROVED);
    }

}