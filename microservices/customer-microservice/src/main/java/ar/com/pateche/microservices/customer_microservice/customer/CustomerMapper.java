package ar.com.pateche.microservices.customer_microservice.customer;


import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Object toCustomerResponse;

    public Customer toCustomer(CustomerRequest request) { // Map the CustomerRequest to a Customer entity
        return Customer.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .address(request.address())
                .city(request.city())
                .build();
    }

    public CustomerResponse toCustomerResponse(Customer customer) {

        return CustomerResponse.builder()
                .id(customer.getId())
                .firstName((customer.getFirstName()))
                .build();

    }

   
    

    

   
}