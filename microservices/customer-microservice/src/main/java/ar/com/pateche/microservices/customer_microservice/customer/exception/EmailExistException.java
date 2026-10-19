package ar.com.pateche.microservices.customer_microservice.customer.exception;

public class EmailExistException extends RuntimeException{
    public EmailExistException(String message){
        super(message);
    }
}
