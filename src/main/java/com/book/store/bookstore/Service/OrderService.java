package com.book.store.bookstore.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.bookstore.Entity.BookOrder;
import com.book.store.bookstore.Entity.Cart;
import com.book.store.bookstore.Repository.CartRepository;
import com.book.store.bookstore.Repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartRepository cartRepository;


    public String addOrder(BookOrder order){
        try {
            Optional<BookOrder> optionalOrder = orderRepository.findById(order.getId());
            if (optionalOrder.isPresent()) {
                return "Order with id already exists";
            } else {
                
                orderRepository.save(order);
                return "Order placed";
            }
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    public List<BookOrder> getAllOrder(){
        return orderRepository.findAll();
    }
    public Optional<BookOrder> getOrderById(int id){
        return orderRepository.findById(id);
    }
    public String updateOrder(BookOrder order){
        Optional<BookOrder> optionalOrder = orderRepository.findById(order.getId());
        if(optionalOrder.isPresent()){
            orderRepository.save(order);
            return "Order details updated";
        }
        return "Order does not exists";
    }
    public String deleteOrder(int id){
        Optional<BookOrder> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isPresent())
        {
            orderRepository.deleteById(id);
            return "Order canceled";
        }
        return "Unable to find Order";
    }
    public String addOrder1(BookOrder order,int id){
      	 try {
               Optional<BookOrder> optionalBilling  =orderRepository.findById(order.getId());
              

               Optional<Cart> optionalPayment= cartRepository.findById(id);
              Cart p=optionalPayment.get();
               order.setCart(p);
               if (optionalBilling.isPresent()) {
                   return "order with id already exists";
               } else {
                   
                  orderRepository.save(order);
                   return "Order placed";
               }
           }
           catch (Exception e){
               return e.getMessage();
           }
      }
      
    public List<BookOrder> getOrderById1(int id) {
		List<BookOrder> optionalBilling = orderRepository.findByCartId(id);
	    return optionalBilling;
	}
    public Optional<BookOrder> getOrderById11(int id){
        return orderRepository.findById(id);
    }
    public String updateOrder11(BookOrder order){
        Optional<BookOrder> optionalOrder = orderRepository.findById(order.getId());
        if(optionalOrder.isPresent()){
            orderRepository.save(order);
            return "Order details updated";
        }
        return "Order does not exists";
    }
    public String deleteOrder11(int id){
        Optional<BookOrder> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isPresent())
        {
            orderRepository.deleteById(id);
            return "Order canceled";
        }
        return "Unable to find Order";
    }
    public List<BookOrder> getAllOrder11(){
        return orderRepository.findAll();
    }
 
    }

