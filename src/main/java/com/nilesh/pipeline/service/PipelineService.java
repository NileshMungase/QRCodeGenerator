package com.nilesh.pipeline.service;

import com.nilesh.pipeline.dto.*;
import com.nilesh.pipeline.entity.*;
import com.nilesh.pipeline.repository.PipelineRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PipelineService {
 private final PipelineRepository repository;
 public PipelineService(PipelineRepository repository){this.repository=repository;}
 public PipelineResponse create(CreatePipelineRequest request){
  if(repository.existsByName(request.name())) throw new IllegalArgumentException("Pipeline name already exists: "+request.name());
  return toResponse(repository.save(new Pipeline(request.name(),request.description())));
 }
 @Transactional(readOnly=true) public List<PipelineResponse> findAll(){return repository.findAll().stream().map(this::toResponse).toList();}
 @Transactional(readOnly=true) public PipelineResponse findById(Long id){return toResponse(getPipeline(id));}
 public PipelineResponse execute(Long id){
  Pipeline pipeline=getPipeline(id); pipeline.setStatus(PipelineStatus.RUNNING); repository.save(pipeline);
  // Replace this placeholder with real build/test/deployment orchestration.
  pipeline.setStatus(PipelineStatus.SUCCESS); return toResponse(repository.save(pipeline));
 }
 public void delete(Long id){repository.delete(getPipeline(id));}
 private Pipeline getPipeline(Long id){return repository.findById(id).orElseThrow(()->new PipelineNotFoundException(id));}
 private PipelineResponse toResponse(Pipeline p){return new PipelineResponse(p.getId(),p.getName(),p.getDescription(),p.getStatus(),p.getCreatedAt(),p.getUpdatedAt());}
}
