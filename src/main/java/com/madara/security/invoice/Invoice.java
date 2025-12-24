package com.madara.security.invoice;

import com.madara.security.client.Client;
import com.madara.security.invoice.status.Status;
import com.madara.security.project.Project;
import com.madara.security.utility.InvoiceSequenceGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoice")
@EntityListeners(AuditingEntityListener.class)
public class Invoice {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "invoice_no", unique = true, nullable = false, updatable = false)
    private String invoiceNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;
    @Column(name = "total_amount")
    private Long totalAmount;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @Column(name = "due_date")
    private LocalDate dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(insertable = false)
    private Instant modifiedAt;

    @PrePersist
    public void generateInvoiceNo() {
        if (this.invoiceNumber == null) {
            String year = String.valueOf(Year.now().getValue());
            Long seq = InvoiceSequenceGenerator.nextVal();
            this.invoiceNumber = "INV-" + year + "-" + String.format("%06d", seq);
        }
    }
}
