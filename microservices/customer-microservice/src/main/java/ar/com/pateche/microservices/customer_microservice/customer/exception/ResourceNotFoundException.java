package ar.com.pateche.microservices.customer_microservice.customer.exception;

import org.springframework.web.client.HttpClientErrorException;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException (String message) {
        super(message);
    }


}
