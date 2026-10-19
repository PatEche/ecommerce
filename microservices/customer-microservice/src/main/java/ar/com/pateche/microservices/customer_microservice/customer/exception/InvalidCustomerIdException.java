package ar.com.pateche.microservices.customer_microservice.customer.exception;

public class InvalidCustomerIdException extends RuntimeException {

    public InvalidCustomerIdException(String message) {
        super(message);
    }

}
