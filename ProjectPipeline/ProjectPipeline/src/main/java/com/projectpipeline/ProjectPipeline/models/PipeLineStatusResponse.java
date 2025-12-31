package com.projectpipeline.ProjectPipeline.models;

import lombok.Data;
import lombok.Generated;

@Data
public class PipeLineStatusResponse {

    @Generated
    public String id;
    private String message;
    private String timestamp = String.valueOf(System.currentTimeMillis());
}


