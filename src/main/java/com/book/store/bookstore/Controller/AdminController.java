package com.book.store.bookstore.Controller;

import com.book.store.bookstore.Dto.BookDto;
import com.book.store.bookstore.Dto.UserDto;
import com.book.store.bookstore.Dto.LoginDto;
import com.book.store.bookstore.Dto.OrderDto;
import com.book.store.bookstore.Entity.Book;
import com.book.store.bookstore.Entity.BookOrder;
import com.book.store.bookstore.Entity.User;
import com.book.store.bookstore.Service.BookService;
import com.book.store.bookstore.Service.OrderService;
import com.book.store.bookstore.Service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class AdminController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AdminService adminService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST, value = "/admin")
    public String addAdmin(@RequestBody UserDto customerDto){
        User customer = new User(customerDto.getName(),customerDto.getEmail(),customerDto.getSaltedPassword(),customerDto.getAddress());
        return adminService.addCustomer(customer);
    }
    @RequestMapping(method = RequestMethod.POST, value="/adminlogin")
    public String getCustomerFromEmailAndPassword1(@RequestBody LoginDto loginDto){
        return adminService.getCustomerFromEmailAndPassword1(loginDto.getEmail(),loginDto.getPassword());
    }
    @RequestMapping(method = RequestMethod.POST, value="/book")
    public String addBook(@RequestBody BookDto bookDto){
        Book book = new Book(bookDto.getName(),bookDto.getAuthor(),bookDto.getPublication(),
                bookDto.getAvailableQuantity(),bookDto.getPrice());
        return bookService.addBook(book);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/book")
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }

    @RequestMapping(method= RequestMethod.GET, value = "/book/{id}")
    public Optional<Book> getBookById(@PathVariable("id")int id){
        return bookService.getBookById(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/book")
    public String updateBook(@RequestBody BookDto bookDto){
        Book book = new Book(bookDto.getId(),bookDto.getName(),bookDto.getAuthor(),bookDto.getPublication(),
                bookDto.getAvailableQuantity(),bookDto.getPrice());
        return bookService.updateBook(book);
    }
    @RequestMapping(method = RequestMethod.DELETE , value = "/book/{id}")
    public String deleteBook(@PathVariable("id")int id){
        return bookService.deleteBook(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/addcustomer")
    public String addCustomer1(@RequestBody UserDto customerDto){
        User customer = new User(customerDto.getName(),customerDto.getEmail(),customerDto.getSaltedPassword(),customerDto.getAddress());
        return adminService.addCustomer(customer);
    }
   
    @RequestMapping(method= RequestMethod.GET , value = "/viewcustomers")
    public List<User> getAllCustomer(){
        return adminService.getAllCustomer();
    }
    @RequestMapping(method = RequestMethod.GET , value="/viewcustomer/{id}")
    public Optional<User> getCustomerById(@PathVariable("id")int id){
        return adminService.getCustomerById(id);
    }
  
    @RequestMapping(method = RequestMethod.DELETE , value="/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable("id")int id){
        return adminService.deleteCustomer(id);
    }
    
    @RequestMapping(method= RequestMethod.GET , value = "/order")
    public List<BookOrder> getAllOrder11(){
        return orderService.getAllOrder11();
    }
    @RequestMapping(method = RequestMethod.GET , value="/order/{id}")
    public Optional<BookOrder> getOrderById11(@PathVariable("id")int id){
        return orderService.getOrderById11(id);
    }
    @RequestMapping(method =RequestMethod.PUT, value = "/order")
    public String updateOrder11(@RequestBody OrderDto orderDto){
    	BookOrder order = new BookOrder(orderDto.getId(),orderDto.getOrder_date(),orderDto.getOrder_total(),orderDto.getOrder_status());
        return orderService.updateOrder11(order);
    }
    @RequestMapping(method = RequestMethod.DELETE , value="/order/{id}")
    public String deleteOrder11(@PathVariable("id")int id){
        return orderService.deleteOrder11(id);
    }
    
    
    
    
    
    
}
