package com.madara.security.response.DTO;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDTO {
    private String projectName;
    private String siteLocation;
    private String projectType;
    private LocalDate startDate;
    private LocalDate dueDate;
    private String material;
    private long estimatedCost;
    private Long managerId;
    private Long clientId;
}
