package nvc.it.web_tesa_cafe.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import nvc.it.web_tesa_cafe.model.Drink;

public interface DrinkRepository extends MongoRepository<Drink ,String>{
    public List<Drink> findByNameContaining(String name);
}