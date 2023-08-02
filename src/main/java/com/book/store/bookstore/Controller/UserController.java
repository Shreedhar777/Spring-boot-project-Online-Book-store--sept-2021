package com.book.store.bookstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.book.store.bookstore.Dto.BillingDto;
import com.book.store.bookstore.Dto.CartDto;
import com.book.store.bookstore.Dto.LoginDto;
import com.book.store.bookstore.Dto.OrderDto;
import com.book.store.bookstore.Dto.PaymentDto;
import com.book.store.bookstore.Dto.ShippingDto;
import com.book.store.bookstore.Dto.UserDto;
import com.book.store.bookstore.Entity.Billing;
import com.book.store.bookstore.Entity.Book;
import com.book.store.bookstore.Entity.BookOrder;
import com.book.store.bookstore.Entity.Cart;
import com.book.store.bookstore.Entity.Payment;
import com.book.store.bookstore.Entity.Shipping;
import com.book.store.bookstore.Entity.User;
import com.book.store.bookstore.Service.BillingService;
import com.book.store.bookstore.Service.BookService;
import com.book.store.bookstore.Service.CartService;
import com.book.store.bookstore.Service.OrderService;
import com.book.store.bookstore.Service.PaymentService;
import com.book.store.bookstore.Service.ShippingService;
import com.book.store.bookstore.Service.UserService;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ShippingService shippingService;
    @Autowired
    private BookService bookService;
    
    @Autowired
    private BillingService billingService;
    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;
    
    @RequestMapping(method = RequestMethod.POST, value = "/user/registration")
    public String addUser(@RequestBody UserDto userDto){
        User user = new User(userDto.getName(),userDto.getEmail(),userDto.getSaltedPassword(),userDto.getAddress());
        return userService.addUser(user);
    }
    @RequestMapping(method = RequestMethod.POST, value="/user/login")
    public String getCustomerFromEmailAndPassword1(@RequestBody LoginDto loginDto){
        return userService.getCustomerFromEmailAndPassword(loginDto.getEmail(),loginDto.getPassword());
    }
   
    
    @RequestMapping(method = RequestMethod.GET , value="/user/profile/{id}")
    public Optional<User> getUserById(@PathVariable("id")int id){
        return userService.getUserById(id);
    }
    @RequestMapping(method =RequestMethod.PUT, value = "/user/profileUpdate")
    public String updateCustomer(@RequestBody UserDto userDto){
        User user = new User(userDto.getId(),userDto.getName(),userDto.getEmail(),userDto.getSaltedPassword(),userDto.getAddress());
        return userService.updateUser(user);
    }
    @RequestMapping(method = RequestMethod.DELETE , value="/user/DeleteAccount/{id}")
    public String deleteUser1(@PathVariable("id")int id){
        return userService.deleteUser(id);
    }
    
    
    
    @RequestMapping(method = RequestMethod.GET, value = "user/bookstore")
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }
    
    //  cart
    
    
    
    @RequestMapping(method = RequestMethod.POST, value = "user/{id1}/book/{id2}/cart")
    public String addPayment1(@RequestBody CartDto cartDto,@PathVariable("id1")int id1,@PathVariable("id2")int id2){
    	  Cart cart = new Cart(cartDto.getId(),cartDto.getQuantity());
        return cartService.addCart1(cart,id1,id2);
    }
    
    @RequestMapping(method = RequestMethod.GET , value="user/{id}/cart")
    public List<Cart> getCartById1(@PathVariable("id")int id){
        return cartService.getCartById1(id);
    }
    
    
    @RequestMapping(method =RequestMethod.PUT, value = "/cart")
    public String updateCart(@RequestBody CartDto cartDto){
    	  Cart cart = new Cart(cartDto.getId(),cartDto.getUser(),cartDto.getBook(),cartDto.getQuantity());
        return cartService.updateCart(cart);
    }
    @RequestMapping(method = RequestMethod.DELETE , value="/cart/{id}")
    public String deleteCart(@PathVariable("id")int id){
        return cartService.deleteCart(id);
    }
    
    
    
    //add payment details
    
    
    @RequestMapping(method = RequestMethod.POST, value = "user/{id}/payment")
    public String addPayment1(@RequestBody PaymentDto paymentDto,@PathVariable("id")int id){
        Payment payment = new Payment(paymentDto.getId(),paymentDto.getCard_name(),paymentDto.getCard_number(),paymentDto.getCvc(),paymentDto.getExpiry_month(),paymentDto.getExpiry_year());
        return paymentService.addPayment1(payment,id);
    }
    @RequestMapping(method = RequestMethod.GET , value="user/{id}/payment")
    public Optional<Payment> getPaymentUserById(@PathVariable("id")int id){
        return paymentService.getPaymentByUserId(id);
    }
    
    @RequestMapping(method =RequestMethod.PUT, value = "user/{id}/payment")
    public String updatePayment(@RequestBody PaymentDto paymentDto){
        Payment payment = new Payment(paymentDto.getId(),paymentDto.getCard_name(),paymentDto.getCard_number(),paymentDto.getCvc(),paymentDto.getExpiry_month(),paymentDto.getExpiry_year(),paymentDto.getUser());
        return paymentService.updatePayment(payment);
    }
    
    
    
    
    
    
  //add billing details
    
    
    
  
    
    @RequestMapping(method = RequestMethod.POST, value = "payment/{id}/billing")
    public String addBilling1(@RequestBody BillingDto billingDto,@PathVariable("id")int id){
        Billing billing = new Billing(billingDto.getId(),billingDto.getUser_billing_city(),billingDto.getUser_billing_country(),billingDto.getUser_billing_name(),billingDto.getUser_billing_state(),billingDto.getUser_billing_street1(),billingDto.getUser_billing_street2(),billingDto.getUser_billing_zipcode());
        return billingService.addBilling1(billing,id);
    }
    @RequestMapping(method = RequestMethod.GET , value="payment/{id}/billing")
    public List<Billing> getBillingById1(@PathVariable("id")int id){
        return billingService.getBillingById1(id);
    }
    @RequestMapping(method =RequestMethod.PUT, value = "payment/{id}/billing")
    public String updateBilling(@RequestBody BillingDto billingDto){
       Billing billing = new Billing(billingDto.getId(),billingDto.getUser_billing_city(),billingDto.getUser_billing_country(),billingDto.getUser_billing_name(),billingDto.getUser_billing_state(),billingDto.getUser_billing_street1(),billingDto.getUser_billing_street2(),billingDto.getUser_billing_zipcode(),billingDto.getPayment());
        return billingService.updateBilling(billing);
    }
    @RequestMapping(method = RequestMethod.DELETE , value="/billing/{id}")
    public String deleteBilling(@PathVariable("id")int id){
        return billingService.deleteBilling(id);
    }
    //add shipping details
    
    
    @RequestMapping(method = RequestMethod.POST, value = "user/{id}/shipping")
    public String addUser1(@RequestBody ShippingDto shippingDto,@PathVariable("id")int id){
        Shipping shipping = new Shipping(shippingDto.getId(),shippingDto.getShipping_address_city(),shippingDto.getShipping_address_country(),shippingDto.getShipping_address_name(),shippingDto.getShipping_address_state(),shippingDto.getShipping_address_street1(),shippingDto.getShipping_address_street2(),shippingDto.getShipping_address_zipcode());
        return shippingService.addShipping1(shipping,id);
    }
    @RequestMapping(method = RequestMethod.GET , value="user/{id}/shipping")
    public List<Shipping> getShippingById(@PathVariable("id")int id){
        return shippingService.getShippingById(id);
    }
    @RequestMapping(method =RequestMethod.PUT, value = "user/{id}/shipping")
    public String updateShipping(@RequestBody ShippingDto shippingDto){
        Shipping shipping = new Shipping(shippingDto.getId(),shippingDto.getShipping_address_city(),shippingDto.getShipping_address_country(),shippingDto.getShipping_address_name(),shippingDto.getShipping_address_state(),shippingDto.getShipping_address_street1(),shippingDto.getShipping_address_street2(),shippingDto.getShipping_address_zipcode(),shippingDto.getUser());
        return shippingService.updateShipping(shipping);
    }
    @RequestMapping(method = RequestMethod.DELETE , value="user/{id2}/shipping/{id}")
    public String deleteUser(@PathVariable("id")int id){
        return shippingService.deleteShipping(id);
    }
    
  
   
    
    // place the order
  
    
    
    @RequestMapping(method = RequestMethod.POST, value = "cart/{id}/order")
    public String addBilling1(@RequestBody OrderDto orderDto,@PathVariable("id")int id){
       BookOrder order = new BookOrder(orderDto.getId(),orderDto.getOrder_date(),orderDto.getOrder_total(),orderDto.getOrder_status());
        return orderService.addOrder1(order, id);
    }
    @RequestMapping(method = RequestMethod.GET , value="cart/{id}/order")
    public List<BookOrder> getOrderById1(@PathVariable("id")int id){
        return orderService.getOrderById1(id);
    }
    
    @RequestMapping(method = RequestMethod.DELETE , value="/cancelorder/{id}")
    public String deleteOrder(@PathVariable("id")int id){
        return orderService.deleteOrder(id);
    }
    
  
  
    
}
