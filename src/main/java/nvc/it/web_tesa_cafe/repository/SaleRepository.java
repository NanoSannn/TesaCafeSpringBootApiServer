package nvc.it.web_tesa_cafe.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import nvc.it.web_tesa_cafe.model.Sale;

public interface SaleRepository extends MongoRepository<Sale, String>{
    public List<Sale> findByNameContaining(String name);
}