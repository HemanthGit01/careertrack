package com.hemanth.careertrack.repository;

import com.hemanth.careertrack.model.ApplicationStatus;
import com.hemanth.careertrack.model.JobApplication;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByStatus(ApplicationStatus status);

    List<JobApplication> findByCompanyNameContainingIgnoreCase(String companyName);
}
