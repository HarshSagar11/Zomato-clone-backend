package com.zomatoclone.Zomato.Clone.advices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {
    private int response_code;
    private String message;
    private T data;
    private LocalDateTime timestamp;
}
