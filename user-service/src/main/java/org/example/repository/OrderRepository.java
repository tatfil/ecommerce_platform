package org.example.repository;

import org.example.model.entity.Order;
import org.example.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Modifying
    @Query("update Order o set o.status = :status where o.id = :orderId")
    void updateOrderStatus(Long orderId, OrderStatus status);

}
