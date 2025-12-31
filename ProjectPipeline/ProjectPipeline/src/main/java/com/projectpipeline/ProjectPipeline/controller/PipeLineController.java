package com.projectpipeline.ProjectPipeline.controller;

import com.projectpipeline.ProjectPipeline.models.PipeLineStatusResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PipeLineController {

    @GetMapping("/status")
    public ResponseEntity<?> status() {
        PipeLineStatusResponse response = new PipeLineStatusResponse();
        response.setMessage("Project Pipeline is running");
        return ResponseEntity.ok(response);
    }
}
 