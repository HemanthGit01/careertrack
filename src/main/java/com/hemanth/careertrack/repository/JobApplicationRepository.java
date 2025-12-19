package com.hemanth.careertrack.repository;

import com.hemanth.careertrack.model.ApplicationStatus;
import com.hemanth.careertrack.model.JobApplication;
import com.hemanth.careertrack.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobApplicationRepository
        extends JpaRepository<JobApplication, Long> {

    List<JobApplication> findByUser(User user);

    List<JobApplication> findByUserAndStatusAndCompanyNameContainingIgnoreCase(
            User user,
            ApplicationStatus status,
            String companyName
    );

    Optional<JobApplication> findByIdAndUser(Long id, User user);

    Page<JobApplication> findByUser(User user, Pageable pageable);
}
