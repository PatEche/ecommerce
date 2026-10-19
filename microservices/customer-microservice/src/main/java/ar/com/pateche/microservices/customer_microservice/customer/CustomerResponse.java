package ar.com.pateche.microservices.customer_microservice.customer;

import lombok.Builder;

@Builder 
public record CustomerResponse(
        String id,
        String firstName) {

}
