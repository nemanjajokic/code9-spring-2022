package com.code9.beershop.exception;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseBody {
    List<String> errors;
    HttpStatus statusCode;
    @Builder.Default
    LocalDateTime timestamp = LocalDateTime.now();
}
