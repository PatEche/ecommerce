package ar.com.pateche.microservices.customer_microservice.customer.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamp,
        int statusCode,
        String error,
        String message,
        String path




) {
}
