package com.nilesh.pipeline.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreatePipelineRequest(
 @NotBlank @Size(max=100) String name,
 @Size(max=500) String description) {}
