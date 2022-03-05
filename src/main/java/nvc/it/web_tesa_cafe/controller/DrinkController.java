package nvc.it.web_tesa_cafe.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nvc.it.web_tesa_cafe.model.Drink;
import nvc.it.web_tesa_cafe.service.DrinkService;

@RestController
@RequestMapping("/drink")
public class DrinkController {
    @Autowired
    private DrinkService drinkService;

    @GetMapping("")
    public ResponseEntity<Object> getDrink(){
        List<Drink> customers = drinkService.getDrink();
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search Customer Succes!");
        map.put("data", customers);
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDrinkById(@PathVariable String id){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search Customer By ID Succes!");
        map.put("data", drinkService.getDrinkById(id));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getDrinkByName(@PathVariable String name){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search Customer By Name Succes!");
        map.put("data", drinkService.getDrinkByName(name));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> addDrink(@RequestBody Drink drink){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Add Customer Succes!");
        map.put("data", drinkService.addDrink(drink));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDrink(@PathVariable String id, @RequestBody Drink drink){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Update Product Succes!");
        map.put("data", drinkService.updateDrink(id, drink));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDrink(@PathVariable String id){
        HashMap<String, Object> map = new HashMap<>();
        if (!drinkService.deleteDrink(id)) {
            map.put("msg", "Error Delete");
            // return new ResponseEntity<Object>(map, HttpStatus.OK);
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            map.put("msg", "Delete Succes!");
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
        
    }
}
