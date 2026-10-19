package ar.com.pateche.microservices.customer_microservice.customer;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customers")

public class CustomerController {

    private final CustomerService service;
    public CustomerController(CustomerService customerService){
        this.service = customerService;
    }

    @PostMapping()
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest Request) {
        return ResponseEntity.ok(service.saveCustomer(Request));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable String customerId) {
        
        return ResponseEntity.ok(service.getCustomerById(customerId));
    }

    @GetMapping()
    public ResponseEntity <List<CustomerResponse>> getListCustomers() {
        
        return ResponseEntity.ok(service.getAllCustomers());
    }


    @DeleteMapping("/{customersId}")
    public ResponseEntity<Void> deleteCustomerById(@Valid @PathVariable ("customersId") String customersId) {

        service.deleteCustomer(customersId);
        return ResponseEntity.accepted().build();

   }

   @PutMapping()
   public ResponseEntity<Void> updateCustomer(@RequestBody CustomerRequest customerRequest) {

        service.updateCustomer(customerRequest);
        return ResponseEntity.ok().build();

   }

    
}
