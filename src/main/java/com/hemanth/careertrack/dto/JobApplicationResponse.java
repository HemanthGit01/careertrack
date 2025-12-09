package com.hemanth.careertrack.dto;

import com.hemanth.careertrack.model.ApplicationStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobApplicationResponse {

    private Long id;

    private String companyName;

    private String jobTitle;

    private String jobLocation;

    private ApplicationStatus status;

    private String applicationSource;

    private LocalDate appliedDate;

    private String jobLink;

    private BigDecimal expectedCtc;

    private BigDecimal offeredCtc;

    private String notes;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
