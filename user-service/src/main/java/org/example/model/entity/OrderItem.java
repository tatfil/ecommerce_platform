package org.example.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_items", schema = "ecommerce")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private Long merchItem;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "undelivered_quantity")
    private Long undeliveredQuantity;

    @Column(name = "comment")
    private String comment;

    @Column(name = "attached_file")
    @Lob
    private byte[] attachedFile;
}