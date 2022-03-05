package nvc.it.web_tesa_cafe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nvc.it.web_tesa_cafe.model.Item;
import nvc.it.web_tesa_cafe.model.Sale;
import nvc.it.web_tesa_cafe.repository.SaleRepository;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> getSale(){
        return saleRepository.findAll();
    }

    public Optional<Sale> getSaleById(String id){
        return saleRepository.findById(id);
    }

    public List<Sale> getSaleByName(String name){
        return saleRepository.findByNameContaining(name);
    }

    public Sale addSale(Sale sale){
        return saleRepository.save(sale);
    }

    public Optional<Sale> updateSale(String id, Sale sale){
        Sale currentSale = saleRepository.findById(id).get();
        currentSale.setName(sale.getName());
        return Optional.of(saleRepository.save(currentSale));
    }

    public Optional<Sale> addItem(String id, Item item){
        Sale currentSale = saleRepository.findById(id).get();
        List<Item> items = currentSale.getItems();
        items.add(item);
        currentSale.setItems(items);
        return Optional.of(saleRepository.save(currentSale));
    }

    public boolean deleteSale(String id){
        try {
            saleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    } 
}
