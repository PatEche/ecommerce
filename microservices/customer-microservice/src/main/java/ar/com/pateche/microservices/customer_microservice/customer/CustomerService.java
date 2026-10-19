package ar.com.pateche.microservices.customer_microservice.customer;

import ar.com.pateche.microservices.customer_microservice.customer.exception.EmailExistException;
import ar.com.pateche.microservices.customer_microservice.customer.exception.InvalidCustomerIdException;
import ar.com.pateche.microservices.customer_microservice.customer.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    public String saveCustomer(CustomerRequest request) {
        if (repository.existsByEmail(request.email())){
            throw new EmailExistException("This email already exist "+ request.email());
        }
        var customer = mapper.toCustomer(request); // Map the request to a Customer entity
        var savedCustomer = repository.save(customer); // Save the customer entity to the database
        return savedCustomer.getId(); // Return the ID of the created customer
    }

    public CustomerResponse getCustomerById(String customerId) {

        boolean result = ObjectId.isValid(customerId);

        if (!result) {

            throw new InvalidCustomerIdException(String.format("INVALID_CUSTOMER_ID:%s ", customerId));
        }

        return repository.findById(customerId)
                .map(mapper::toCustomerResponse)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Customer with id %s not found", customerId)));


    }

    public List<CustomerResponse> getAllCustomers() {

        /**
         * Traigo todos los registros de la DB y los guardo en una lista de tipo
         * Customer.
         */
        List<Customer> customers = repository.findAll();

        /**
         Paso la lista original por el stream le paso la funcion map
         llamo a mi mapper la cual recibe un Customer y devuelve un CustomerResponse
         */

        return customers.stream().map(mapper::toCustomerResponse).toList();
        // return customers.stream().map(mapper::toCustomerResponse).collect(Collectors.toList());

        /**
         * Otro variante seria
         * var customerResponse = customers.stream().map(mapper::toCustomerResponse);
         * return customerResponse.toList();
         */

    }

    public void deleteCustomer(String customersId) {

        Customer idFound = repository.findById(customersId).orElseThrow();

        repository.deleteById(idFound.getId());
        System.out.println("Customer with id:" + idFound + "was delete succesfully");

    }

    public void updateCustomer(CustomerRequest customerRequest) {

        Customer customerFound = repository.findById(customerRequest.id()).orElseThrow(() -> new RuntimeException("The resource not found with id:" + customerRequest.id()));
        customerFound.getId();
        customerFound.setFirstName(customerRequest.firstName());
        customerFound.setLastName(customerRequest.lastName());
        customerFound.setEmail(customerRequest.email());
        customerFound.setPhone(customerRequest.phone());
        customerFound.setAddress(customerRequest.address());
        customerFound.setCity(customerRequest.city());

        repository.save(customerFound);

        System.out.println(customerFound);

    }
}
