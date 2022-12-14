package com.mehisen.product.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class APIError {
    private HttpStatus status;
    private List<String> errors;
    private LocalDateTime timestamp;
    private String pathUri;
}
