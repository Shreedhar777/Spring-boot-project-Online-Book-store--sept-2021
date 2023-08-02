package com.book.store.bookstore.Dto;

import com.book.store.bookstore.Entity.Payment;

public class BillingDto  {
    
	 private int id; 
	    private String user_billing_city;
	    private String  user_billing_country;
	    private String  user_billing_name ;
	    private String  user_billing_state ;
	    private String user_billing_street1;
	    private String user_billing_street2 ;
	    private String  user_billing_zipcode ;
	    private Payment payment;
	    
		public Payment getPayment() {
			return payment;
		}
		public void setPayment(Payment payment) {
			this.payment = payment;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUser_billing_city() {
			return user_billing_city;
		}
		public void setUser_billing_city(String user_billing_city) {
			this.user_billing_city = user_billing_city;
		}
		public String getUser_billing_country() {
			return user_billing_country;
		}
		public void setUser_billing_country(String user_billing_country) {
			this.user_billing_country = user_billing_country;
		}
		public String getUser_billing_name() {
			return user_billing_name;
		}
		public void setUser_billing_name(String user_billing_name) {
			this.user_billing_name = user_billing_name;
		}
		public String getUser_billing_state() {
			return user_billing_state;
		}
		public void setUser_billing_state(String user_billing_state) {
			this.user_billing_state = user_billing_state;
		}
		public String getUser_billing_street1() {
			return user_billing_street1;
		}
		public void setUser_billing_street1(String user_billing_street1) {
			this.user_billing_street1 = user_billing_street1;
		}
		public String getUser_billing_street2() {
			return user_billing_street2;
		}
		public void setUser_billing_street2(String user_billing_street2) {
			this.user_billing_street2 = user_billing_street2;
		}
		public String getUser_billing_zipcode() {
			return user_billing_zipcode;
		}
		public void setUser_billing_zipcode(String user_billing_zipcode) {
			this.user_billing_zipcode = user_billing_zipcode;
		}
	    

	    
	

}
