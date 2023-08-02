package com.book.store.bookstore.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.bookstore.Entity.Shipping;
import com.book.store.bookstore.Entity.User;
import com.book.store.bookstore.Repository.ShippingRepository;
import com.book.store.bookstore.Repository.UserRepository;

import java.util.*;


@Service
public class ShippingService {
    @Autowired
    private ShippingRepository shippingRepository;
    @Autowired
    private UserRepository userRepository;

    public String addShipping(Shipping shipping){
        try {
            Optional<Shipping> optionalShipping = shippingRepository.findById(shipping.getId());
            if (optionalShipping.isPresent()) {
                return "shipping with id already exists";
            } else {
                
                shippingRepository.save(shipping);
                return "shipping address has been added";
            }
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    public String addShipping1(Shipping shipping,int id){
        try {
            Optional<Shipping> optionalShipping  = shippingRepository.findById(shipping.getId());
           
            Optional<User> optionalUser= userRepository.findById(id);
            User u=optionalUser.get();
            shipping.setUser(u);
            if (optionalShipping.isPresent()) {
                return "shipping with id already exists";
            } else {
                
                shippingRepository.save(shipping);
                return "shipping address has been added";
            }
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    public List<Shipping> getAllShipping(){
        return shippingRepository.findAll();
    }
    public List<Shipping> getShippingById(int id){
    	List<Shipping> optionalShipping = shippingRepository.findByUserId(id);
    return optionalShipping;
    	
    }
    public String updateShipping(Shipping shipping){
        Optional<Shipping> optionalShipping = shippingRepository.findById(shipping.getId());
        if(optionalShipping.isPresent()){
            shippingRepository.save(shipping);
            return "Shipping address updated";
        }
        return "Shipping address does not exists";
    }
    public String deleteShipping
    (int id){
        Optional<Shipping> optionalShipping = shippingRepository.findById(id);
        if(optionalShipping.isPresent())
        {
            shippingRepository.deleteById(id);
            return "Shipping address deleted";
        }
        return "Unable to find Shipping address";
    }

  
  
   
   
 
    }

