package com.hemanth.careertrack.dto;

import com.hemanth.careertrack.model.ApplicationStatus;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobApplicationRequest {

    @NotBlank(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "Job title is required")
    private String jobTitle;

    @NotBlank(message = "Location is required")
    private String location;

    @NotNull(message = "Status is required")
    private ApplicationStatus status;

    private String applicationSource;

    private LocalDate appliedDate;

    @Size(max = 500, message = "Job link must be at most 500 characters")
    private String jobLink;

    @PositiveOrZero(message = "Expected CTC must be zero or positive")
    private BigDecimal expectedCtc;

    @PositiveOrZero(message = "Offered CTC must be zero or positive")
    private BigDecimal offeredCtc;

    @Size(max = 2000, message = "Notes must be at most 2000 characters")
    private String notes;
}
