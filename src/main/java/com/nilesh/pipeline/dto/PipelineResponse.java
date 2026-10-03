package com.nilesh.pipeline.dto;

import com.nilesh.pipeline.entity.PipelineStatus;
import java.time.Instant;

public record PipelineResponse(Long id,String name,String description,PipelineStatus status,Instant createdAt,Instant updatedAt) {}
