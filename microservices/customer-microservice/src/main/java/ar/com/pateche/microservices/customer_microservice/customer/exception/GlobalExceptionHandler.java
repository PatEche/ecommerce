package ar.com.pateche.microservices.customer_microservice.customer.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Component
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllUncaughtExceptions(Exception ex, HttpServletRequest request) {
        log.error("", ex.getMessage(), ex);

        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server error. Please contact to administrator or try to more late.",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex, HttpServletRequest request) {

        //Registro el error
        log.error("Resource was not found:{}", ex.getMessage(), ex);

        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "CUSTOMER_NOT_FOUND",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);


    }

    @ExceptionHandler(InvalidCustomerIdException.class)
    public ResponseEntity<ErrorResponse> handleInvalidCustomerId(InvalidCustomerIdException ex, HttpServletRequest request) {

        log.warn("Id was not found:{}", ex.getMessage(), ex);

        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "INVALID_CUSTOMER_ID",
                ex.getMessage(),
                request.getRequestURI()

        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }

    @ExceptionHandler(EmailExistException.class)
    public ResponseEntity<ErrorResponse> handleEmailExistException(EmailExistException em, HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                "Conflict",
                em.getMessage(),
                request.getRequestURI()


        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);


    }


}
