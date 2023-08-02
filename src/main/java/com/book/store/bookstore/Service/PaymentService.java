package com.book.store.bookstore.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.bookstore.Entity.Payment;
import com.book.store.bookstore.Entity.User;
import com.book.store.bookstore.Repository.PaymentRepository;
import com.book.store.bookstore.Repository.UserRepository;

import java.util.*;


@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private UserRepository userRepository;
    

    public String addBilling(Payment payment){
        try {
            Optional<Payment> optionalPayment = paymentRepository.findById(payment.getId());
            if (optionalPayment.isPresent()) {
                return "Payment with id already exists";
            } else {
                
                paymentRepository.save(payment);
                return "Payment deatils  has been added";
            }
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    public String addPayment1(Payment payment,int id){
    	 try {
             Optional<Payment> optionalPayment  = paymentRepository.findById(payment.getId());
            

             Optional<User> optionalUser= userRepository.findById(id);
             User u=optionalUser.get();
             payment.setUser(u);
             if (optionalPayment.isPresent()) {
                 return "payment with id already exists";
             } else {
                 
                paymentRepository.save(payment);
                 return "payment details has been added";
             }
         }
         catch (Exception e){
             return e.getMessage();
         }
    }
    
    
    
    
    
    
    
    
    
    
    public List<Payment> getAllPayment(){
        return paymentRepository.findAll();
    }
    public Optional<Payment> getPaymentById(int id){
        return paymentRepository.findById(id);
    }
    public String updatePayment (Payment payment){
        Optional<Payment> optionalPayment  = paymentRepository.findById(payment.getId());
        if(optionalPayment .isPresent()){
            paymentRepository.save(payment);
            return "Payment details  updated";
        }
        return "Payment  does not exists";
    }
    public String deletePayment
    (int id){
        Optional<Payment> optionalPayment= paymentRepository.findById(id);
        if(optionalPayment.isPresent())
        {
            paymentRepository.deleteById(id);
            return "Payment details deleted";
        }
        return "Unable to find Payment ";
    }
	public Optional<Payment> getPaymentByUserId(int id) {
		
		return paymentRepository.findByUserId(id);
	}

  
	/* public String updatePayment1(Payment payment,int id){
	        Optional<Payment> optionalPayment  = paymentRepository.findByUserId(id);
	        if(optionalPayment .isPresent()){
	            paymentRepository.save(payment);
	            return "Payment  updated";
	        }
	        return "Payment  does not exists";
	    } */
	public String updatePayment1(Payment payment, int id) {
		 Optional<Payment> optionalPayment  = paymentRepository.findById(payment.getId());
		 Optional<User> optionalu = userRepository.findById(id);
		User u=optionalu.get();
	        if(optionalPayment .isPresent()){
	        	
	     		payment.setUser(u);
	            paymentRepository.save(payment);
	            return "Payment  details updated";
	        }
	        return "Payment  does not exists";
	}
   
   
 
    }

