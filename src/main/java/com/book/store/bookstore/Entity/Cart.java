package com.book.store.bookstore.Entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
public class Cart {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    private Book book;
    
     private int quantity;
  
     
   

    public Cart(){}







	public Cart(int id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}







	public Cart(int id, User user, Book book, int quantity) {
		super();
		this.id = id;
		this.user = user;
		this.book= book;
		this.quantity = quantity;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", book=" + book+ ", quantity=" + quantity + "]";
	}
   

    
}
