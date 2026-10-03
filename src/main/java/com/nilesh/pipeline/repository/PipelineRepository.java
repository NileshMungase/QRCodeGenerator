package com.nilesh.pipeline.repository;

import com.nilesh.pipeline.entity.Pipeline;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PipelineRepository extends JpaRepository<Pipeline,Long> {
 Optional<Pipeline> findByName(String name);
 boolean existsByName(String name);
}
