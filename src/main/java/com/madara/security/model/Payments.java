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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
@EntityListeners(AuditingEntityListener.class)
public class Payments {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "amount_paid")
    private Long amountPaid;
    @Column(name = "payment_method")
    private String paymentMethod;

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
