package nvc.it.web_tesa_cafe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nvc.it.web_tesa_cafe.model.Customer;
import nvc.it.web_tesa_cafe.model.FavoriteDrink;
import nvc.it.web_tesa_cafe.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    
    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(String id){
        return customerRepository.findById(id);
    }

    public List<Customer> getCustomerByName(String name){
        return customerRepository.findByNameContaining(name);
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Optional<Customer> updateCustomer(String id, Customer customer){
        Customer currentCustomer = customerRepository.findById(id).get();
        currentCustomer.setName(customer.getName());
        currentCustomer.setEmail(customer.getEmail());
        currentCustomer.setTel(customer.getTel());
        return Optional.of(customerRepository.save(currentCustomer));
    }

    public Optional<Customer> addFavoriteDrink(String id, FavoriteDrink favoriteDrink){
        Customer currentProduct = customerRepository.findById(id).get();
        List<FavoriteDrink> favoriteDrinks = currentProduct.getFavoriteDrinks();
        favoriteDrinks.add(favoriteDrink);
        currentProduct.setFavoriteDrinks(favoriteDrinks);
        return Optional.of(customerRepository.save(currentProduct));
    }

    public boolean deleteCustomer(String id){
        try {
            customerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
