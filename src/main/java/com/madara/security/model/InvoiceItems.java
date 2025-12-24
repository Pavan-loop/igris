package com.madara.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoice_items")
@EntityListeners(AuditingEntityListener.class)
public class InvoiceItems {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "rate")
    private Long rate;
    @Column(name = "total_price")
    private Long totalPrice;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(insertable = false)
    private Instant modifiedAt;

}
