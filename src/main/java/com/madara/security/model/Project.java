package com.madara.security.model;

import com.madara.security.model.project.Status;
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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
@EntityListeners(AuditingEntityListener.class)
public class Project {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "site_location")
    private String siteLocation;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "due_date")
    private LocalDate dueDate;
    @Column(name = "material")
    private String material;
    @Column(name = "estimated_cost")
    private Long estimatedCost;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private User manager;


    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(insertable = false)
    private Instant modifiedAt;
}
