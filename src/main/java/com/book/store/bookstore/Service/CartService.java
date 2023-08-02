package com.book.store.bookstore.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.bookstore.Entity.Billing;
import com.book.store.bookstore.Entity.Book;
import com.book.store.bookstore.Entity.Cart;
import com.book.store.bookstore.Entity.User;
import com.book.store.bookstore.Repository.BookRepository;
import com.book.store.bookstore.Repository.CartRepository;
import com.book.store.bookstore.Repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    public String addCart(Cart cart){
        try {
            Optional<Cart> optionalCart = cartRepository.findById(cart.getId());
            if (optionalCart.isPresent()) {
                return "Cart with id already exists";
            } else {
                
                cartRepository.save(cart);
                return "Added  to cart";
            }
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    public List<Cart> getAllCart(){
        return cartRepository.findAll();
    }
    public Optional<Cart> getCartById(int id){
        return cartRepository.findById(id);
    }
    public String updateCart(Cart cart){
        Optional<Cart> optionalCart = cartRepository.findById(cart.getId());
        if(optionalCart.isPresent()){
            cartRepository.save(cart);
            return "Cart updated";
        }
        return "cart does not exists";
    }
    public String addCart1(Cart cart,int id1,int id2){
   	 try {
            Optional<Cart> optionalCart  = cartRepository.findById(cart.getId());
           

            Optional<User> optionalUser= userRepository.findById(id1);
            Optional<Book> optionalBook= bookRepository.findById(id2);
            
            User u=optionalUser.get();
            Book b=optionalBook.get();
            cart.setUser(u);
            cart.setBook(b);
            if (optionalCart.isPresent()) {
                return "Cart with id already exists";
            } else {
                
               cartRepository.save(cart);
                return "Added to cart";
            }
        }
        catch (Exception e){
            return e.getMessage();
        }
   }
	public List<Cart> getCartById1(int id) {
		
		
			List<Cart> optionalcart = cartRepository.findByUserId(id);
		    return optionalcart;
		
	}
   
  
  
	 public String deleteCart
	    (int id){
	        Optional<Cart> optionalBilling = cartRepository.findById(id);
	        if(optionalBilling.isPresent())
	        {
	            cartRepository.deleteById(id);
	            return "Cart item deleted";
	        }
	        return "Unable to find cart";
	    }
  

}
