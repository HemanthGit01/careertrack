package com.hemanth.careertrack.repository;

import com.hemanth.careertrack.model.ApplicationStatus;
import com.hemanth.careertrack.model.JobApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    Page<JobApplication> findByStatus(ApplicationStatus status, Pageable pageable);

    Page<JobApplication> findByCompanyNameContainingIgnoreCase(String companyName, Pageable pageable);

    Page<JobApplication> findByStatusAndCompanyNameContainingIgnoreCase(
            ApplicationStatus status, String companyName, Pageable pageable
    );
}
