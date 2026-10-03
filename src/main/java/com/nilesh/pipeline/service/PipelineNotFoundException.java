package com.nilesh.pipeline.service;

public class PipelineNotFoundException extends RuntimeException {
 public PipelineNotFoundException(Long id){super("Pipeline not found: "+id);}
}
