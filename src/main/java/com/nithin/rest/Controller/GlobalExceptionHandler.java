package com.nithin.rest.Controller;
import com.nithin.rest.Model.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse>handleValidationException(MethodArgumentNotValidException e){
        List<FieldError> errors=e.getBindingResult().getFieldErrors();
        Map<String,String> map=new HashMap<>();
        for(FieldError error: errors){
          map.put(error.getField(),error.getDefaultMessage());
        }
        ErrorResponse errorResponse=new ErrorResponse(400,"Validation failed",map);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

    }
}
