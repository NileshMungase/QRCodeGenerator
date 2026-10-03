package com.nilesh.pipeline.exception;

import com.nilesh.pipeline.service.PipelineNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(PipelineNotFoundException.class) @ResponseStatus(HttpStatus.NOT_FOUND)
 public Map<String,Object> notFound(PipelineNotFoundException ex){return error(HttpStatus.NOT_FOUND,ex.getMessage());}
 @ExceptionHandler(IllegalArgumentException.class) @ResponseStatus(HttpStatus.CONFLICT)
 public Map<String,Object> conflict(IllegalArgumentException ex){return error(HttpStatus.CONFLICT,ex.getMessage());}
 @ExceptionHandler(MethodArgumentNotValidException.class) @ResponseStatus(HttpStatus.BAD_REQUEST)
 public Map<String,Object> validation(MethodArgumentNotValidException ex){
  String message=ex.getBindingResult().getFieldErrors().stream().findFirst()
   .map(e->e.getField()+": "+e.getDefaultMessage()).orElse("Invalid request");
  return error(HttpStatus.BAD_REQUEST,message);
 }
 private Map<String,Object> error(HttpStatus status,String message){return Map.of("timestamp",Instant.now(),"status",status.value(),"error",status.getReasonPhrase(),"message",message);}
}
