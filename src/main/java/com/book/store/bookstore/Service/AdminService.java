package com.book.store.bookstore.Service;
import com.book.store.bookstore.Entity.User;


import com.book.store.bookstore.Repository.AdminRepository;
import com.book.store.bookstore.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class AdminService {
    private static final String LOGIN_MESSAGE="Login First";
  
    @Autowired
    private UserRepository userRepository;

    public String addCustomer(User user){
        try {
            Optional<User> optionalCustomer = userRepository.findById(user.getId());
            if (optionalCustomer.isPresent()) {
                return "User with id already exists";
            } else {
                
                userRepository.save(user);
                return "User has been added";
            }
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    public List<User> getAllCustomer(){
        return userRepository.findAll();
    }
    public Optional<User> getCustomerById(int id){
        return userRepository.findById(id);
    }
    public String deleteCustomer(int id){
        Optional<User> optionalCustomer = userRepository.findById(id);
        if(optionalCustomer.isPresent())
        {
            userRepository.deleteById(id);
            return "User deleted";
        }
        return "Unable to find user";
    }
  
    public String getCustomerFromEmailAndPassword1(String email, String password){
    	Optional<User> aa= userRepository.findByEmailAndSaltedPassword(email,password);
    	User c=aa.get();
    	if(c!=null)
    	{
    		c=null;
    		return "Login successfull";
    		
    	}
    	
    	else
    		return "Login Failed";
    }
}
