package org.example.repository;

import org.example.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Transactional
    @Modifying
    @Query("delete from OrderItem o where o.order.id = ?1")
    int deleteByOrderId(Long orderId);

}
