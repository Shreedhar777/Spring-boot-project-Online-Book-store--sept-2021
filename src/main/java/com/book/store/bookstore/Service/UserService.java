package com.book.store.bookstore.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.bookstore.Entity.User;
import com.book.store.bookstore.Repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    private static final String LOGIN_MESSAGE="Login First";
    @Autowired
    private UserRepository userRepository;

    public String addUser(User user){
        try {
            Optional<User> optionalUser = userRepository.findById(user.getId());
            if (optionalUser.isPresent()) {
                return "User with id already exists";
            } else {
                
                userRepository.save(user);
                return "User is registered successfully";
            }
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }
    public String updateUser(User user){
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if(optionalUser.isPresent()){
            userRepository.save(user);
            return "User details updated";
        }
        return "User does not exists";
    }
    public String deleteUser
    (int id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent())
        {
            userRepository.deleteById(id);
            return "User deleted";
        }
        return "Unable to find user";
    }

  
  
   
   
    public String getCustomerFromEmailAndPassword(String email, String password){
        Optional<User> ou= userRepository.findByEmailAndSaltedPassword(email,password);
        User u=ou.get();
        if(u!=null)
        {
        	u=null;
        	return "Login successful";
        			}
        else
        	return "INVALID CREDENTIALS";
    }
}
