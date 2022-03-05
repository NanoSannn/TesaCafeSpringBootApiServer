package nvc.it.web_tesa_cafe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nvc.it.web_tesa_cafe.model.Drink;
import nvc.it.web_tesa_cafe.repository.DrinkRepository;

@Service
public class DrinkService {
    @Autowired
    private DrinkRepository drinkRepository;

    public List<Drink> getDrink(){
        return drinkRepository.findAll();
    }

    public Optional<Drink> getDrinkById(String id){
        return drinkRepository.findById(id);
    }

    public List<Drink> getDrinkByName(String name){
        return drinkRepository.findByNameContaining(name);
    }

    public Drink addDrink(Drink drink){
        return drinkRepository.save(drink);
    }

    public Optional<Drink> updateDrink(String id, Drink drink){
        Drink currentDrink = drinkRepository.findById(id).get();
        currentDrink.setName(drink.getName());
        return Optional.of(drinkRepository.save(currentDrink));
    }

    public boolean deleteDrink(String id){
        try {
            drinkRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    } 
}
