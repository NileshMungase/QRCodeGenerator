package com.nilesh.pipeline.controller;

import com.nilesh.pipeline.dto.*;
import com.nilesh.pipeline.service.PipelineService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pipelines")
public class PipelineController {
 private final PipelineService service;
 public PipelineController(PipelineService service){this.service=service;}
 @GetMapping public List<PipelineResponse> findAll(){return service.findAll();}
 @GetMapping("/{id}") public PipelineResponse findById(@PathVariable Long id){return service.findById(id);}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public PipelineResponse create(@Valid @RequestBody CreatePipelineRequest request){return service.create(request);}
 @PostMapping("/{id}/execute") public PipelineResponse execute(@PathVariable Long id){return service.execute(id);}
 @GetMapping("/{id}/status") public PipelineResponse status(@PathVariable Long id){return service.findById(id);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){service.delete(id);}
}
