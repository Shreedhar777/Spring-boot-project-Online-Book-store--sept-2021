package com.book.store.bookstore.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class BookOrder {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;
    private String order_date;
    private  int order_total;
    private String order_status="ongoing";
    @OneToOne
    @JoinColumn(name="cart_id")
    private Cart cart;
    
    
    
    
	public BookOrder(int id, String order_date, int order_total, String order_status) {
		super();
		this.id = id;
		this.order_date = order_date;
		this.order_total = order_total;
		this.order_status = order_status;
	}
	public BookOrder() {
		super();
	}
	public BookOrder(int id, String order_date, int order_total, String order_status, Cart cart) {
		super();
		this.id = id;
		this.order_date = order_date;
		this.order_total = order_total;
		this.order_status = order_status;
		this.cart = cart;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getOrder_total() {
		return order_total;
	}
	public void setOrder_total(int order_total) {
		this.order_total = order_total;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
   
    
  


    
}
