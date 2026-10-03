package com.nilesh.pipeline.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name="pipelines")
public class Pipeline {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true,length=100) private String name;
 @Column(length=500) private String description;
 @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private PipelineStatus status=PipelineStatus.CREATED;
 @Column(nullable=false,updatable=false) private Instant createdAt;
 @Column(nullable=false) private Instant updatedAt;
 protected Pipeline(){}
 public Pipeline(String name,String description){this.name=name;this.description=description;}
 @PrePersist void onCreate(){Instant now=Instant.now();createdAt=now;updatedAt=now;}
 @PreUpdate void onUpdate(){updatedAt=Instant.now();}
 public Long getId(){return id;} public String getName(){return name;} public String getDescription(){return description;}
 public PipelineStatus getStatus(){return status;} public Instant getCreatedAt(){return createdAt;} public Instant getUpdatedAt(){return updatedAt;}
 public void setStatus(PipelineStatus status){this.status=status;}
}
