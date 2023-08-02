package com.book.store.bookstore.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.bookstore.Entity.Billing;
import com.book.store.bookstore.Entity.Payment;
import com.book.store.bookstore.Entity.Shipping;
import com.book.store.bookstore.Repository.BillingRepository;
import com.book.store.bookstore.Repository.PaymentRepository;

import java.util.*;


@Service
public class BillingService {
    @Autowired
    private BillingRepository billingRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    public String addBilling(Billing billing){
        try {
            Optional<Billing> optionalBilling = billingRepository.findById(billing.getId());
            if (optionalBilling.isPresent()) {
                return "Billing details with id already exists";
            } else {
                
                billingRepository.save(billing);
                return "Billing address has been added";
            }
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    
    public String addBilling1(Billing billing,int id){
   	 try {
            Optional<Billing> optionalBilling  = billingRepository.findById(billing.getId());
           

            Optional<Payment> optionalPayment= paymentRepository.findById(id);
            Payment p=optionalPayment.get();
            billing.setPayment(p);
            if (optionalBilling.isPresent()) {
                return "billing with id already exists";
            } else {
                
               billingRepository.save(billing);
                return "billing has been added";
            }
        }
        catch (Exception e){
            return e.getMessage();
        }
   }
   
    
    
    
    
    
    
    public List<Billing> getAllBilling(){
        return billingRepository.findAll();
    }
    public Optional<Billing> getBillingById(int id){
        return billingRepository.findById(id);
    }
    public String updateBilling(Billing billing){
        Optional<Billing> optionalBilling = billingRepository.findById(billing.getId());
        if(optionalBilling.isPresent()){
            billingRepository.save(billing);
            return "Billing address updated";
        }
        return "Billing address does not exists";
    }
    public String deleteBilling
    (int id){
        Optional<Billing> optionalBilling = billingRepository.findById(id);
        if(optionalBilling.isPresent())
        {
            billingRepository.deleteById(id);
            return "Billing address deleted";
        }
        return "Unable to find Billing address";
    }

	public List<Billing> getBillingById1(int id) {
		List<Billing> optionalBilling = billingRepository.findByPaymentId(id);
	    return optionalBilling;
	}

  

   
   
 
    }

