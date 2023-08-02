package com.book.store.bookstore.Dto;



import java.io.Serializable;

import javax.persistence.ManyToOne;

import com.book.store.bookstore.Entity.Book;
import com.book.store.bookstore.Entity.User;



public class CartDto  {
	   private int id;
	  
	     private User user;
	   
	     private Book book;
	     private int quantity;
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
	     
	
    
}
