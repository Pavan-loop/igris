package com.madara.security.response.DTO;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private HttpStatus status;
    private String message;
    private T data;
}
