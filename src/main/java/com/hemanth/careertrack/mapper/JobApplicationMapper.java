package com.hemanth.careertrack.mapper;

import com.hemanth.careertrack.dto.JobApplicationRequest;
import com.hemanth.careertrack.dto.JobApplicationResponse;
import com.hemanth.careertrack.model.JobApplication;

import java.util.List;
import java.util.stream.Collectors;

public class JobApplicationMapper {

    private JobApplicationMapper() {
        // utility class, no instances
    }

    public static JobApplication toEntity(JobApplicationRequest dto) {
        if (dto == null) {
            return null;
        }

        return JobApplication.builder()
                .companyName(dto.getCompanyName())
                .jobTitle(dto.getJobTitle())
                .jobLocation(dto.getJobLocation())
                .status(dto.getStatus())
                .applicationSource(dto.getApplicationSource())
                .appliedDate(dto.getAppliedDate())
                .jobLink(dto.getJobLink())
                .expectedCtc(dto.getExpectedCtc())
                .offeredCtc(dto.getOfferedCtc())
                .notes(dto.getNotes())
                .build();
    }

    public static JobApplicationResponse toResponse(JobApplication entity) {
        if (entity == null) {
            return null;
        }

        return JobApplicationResponse.builder()
                .id(entity.getId())
                .companyName(entity.getCompanyName())
                .jobTitle(entity.getJobTitle())
                .jobLocation(entity.getJobLocation())
                .status(entity.getStatus())
                .applicationSource(entity.getApplicationSource())
                .appliedDate(entity.getAppliedDate())
                .jobLink(entity.getJobLink())
                .expectedCtc(entity.getExpectedCtc())
                .offeredCtc(entity.getOfferedCtc())
                .notes(entity.getNotes())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static List<JobApplicationResponse> toResponseList(List<JobApplication> entities) {
        return entities.stream()
                .map(JobApplicationMapper::toResponse)
                .collect(Collectors.toList());
    }
}
