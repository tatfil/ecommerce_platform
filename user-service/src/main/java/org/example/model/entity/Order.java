package org.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.enums.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders", schema = "ecommerce")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    private Set<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "requester")
    private User requester;

    @ManyToOne
    @JoinColumn(name = "responsible")
    private User responsible;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @Column(name = "creation_date")

    private LocalDateTime creationDate;

    @Lob
    @Column(name = "attached_file")
    private byte[] attachedFile;

    private String address;

    @Column(name = "items_count")
    private Integer itemsCount;

}