package nvc.it.web_tesa_cafe.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import nvc.it.web_tesa_cafe.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    public List<Customer> findByNameContaining(String name);
}