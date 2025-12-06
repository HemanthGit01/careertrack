package com.hemanth.careertrack.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name= "job_applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="company_name", nullable = false)
    private String companyName;

    @Column(name="job_title" , nullable = false)
    private String jobTitle;

    @Column(name="job_location")
    private String jobLocation;

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false)
    private ApplicationStatus status;

    @Column(name="application_source")
    private String applicationSource;

    @Column(name="applied_date")
    private LocalDate appliedDate;

    @Column(name="job_link", length = 500)
    private String jobLink;

    @Column(name="expected_ctc", precision = 10, scale = 2)
    private BigDecimal expectedCtc;

    @Column(name="offered_ctc", precision = 10, scale = 2)
    private BigDecimal offeredCtc;

    @Column(name="notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name="created_at" , nullable = false)
    private LocalDateTime createdAt;

    @Column(name="updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;

        if(this.status == null){
            this.status = ApplicationStatus.APPLIED;
        }
    }

    @PreUpdate
    public void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }


}
