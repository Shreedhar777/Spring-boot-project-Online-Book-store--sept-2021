package com.book.store.bookstore.Dto;



import java.io.Serializable;

import com.book.store.bookstore.Entity.User;


public class PaymentDto  {
    
	 private int id; 
	    private String card_name;
	    private String  card_number ;
	    private int  cvc ;
	    private int expiry_month ;
	    private int  expiry_year ;
	    private User user;
	    
	    
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public PaymentDto(int id, String card_name, String card_number, int cvc, int expiry_month, int expiry_year,
				User user) {
			super();
			this.id = id;
			this.card_name = card_name;
			this.card_number = card_number;
			this.cvc = cvc;
			this.expiry_month = expiry_month;
			this.expiry_year = expiry_year;
			this.user = user;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCard_name() {
			return card_name;
		}
		public void setCard_name(String card_name) {
			this.card_name = card_name;
		}
		public String getCard_number() {
			return card_number;
		}
		public void setCard_number(String card_number) {
			this.card_number = card_number;
		}
		
		public int getCvc() {
			return cvc;
		}
		public void setCvc(int cvc) {
			this.cvc = cvc;
		}
		public int getExpiry_month() {
			return expiry_month;
		}
		public void setExpiry_month(int expiry_month) {
			this.expiry_month = expiry_month;
		}
		public int getExpiry_year() {
			return expiry_year;
		}
		public void setExpiry_year(int expiry_year) {
			this.expiry_year = expiry_year;
		}
	    
	 
	    
	

}
