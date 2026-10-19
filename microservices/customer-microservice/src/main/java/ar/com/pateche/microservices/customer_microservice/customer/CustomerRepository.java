package ar.com.pateche.microservices.customer_microservice.customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    boolean existsByEmail(String s);
}
