package com.book.store.bookstore.Dto;



import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.book.store.bookstore.Entity.User;




public class ShippingDto  {
 
	 private int id; 
	    private String  shipping_address_city;
	    private String  shipping_address_country;
	    private String  shipping_address_name ;
	    private String  shipping_address_state ;
	    private String shipping_address_street1;
	    private String shipping_address_street2 ;
	    private String  shipping_address_zipcode ;
	    private int user_id;
	    private User user;
	    
		public ShippingDto(int id, String shipping_address_city, String shipping_address_country,
				String shipping_address_name, String shipping_address_state, String shipping_address_street1,
				String shipping_address_street2, String shipping_address_zipcode, User user) {
			super();
			this.id = id;
			this.shipping_address_city = shipping_address_city;
			this.shipping_address_country = shipping_address_country;
			this.shipping_address_name = shipping_address_name;
			this.shipping_address_state = shipping_address_state;
			this.shipping_address_street1 = shipping_address_street1;
			this.shipping_address_street2 = shipping_address_street2;
			this.shipping_address_zipcode = shipping_address_zipcode;
			this.user = user;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getShipping_address_city() {
			return shipping_address_city;
		}
		public void setShipping_address_city(String shipping_address_city) {
			this.shipping_address_city = shipping_address_city;
		}
		public String getShipping_address_country() {
			return shipping_address_country;
		}
		public void setShipping_address_country(String shipping_address_country) {
			this.shipping_address_country = shipping_address_country;
		}
		public String getShipping_address_name() {
			return shipping_address_name;
		}
		public void setShipping_address_name(String shipping_address_name) {
			this.shipping_address_name = shipping_address_name;
		}
		public String getShipping_address_state() {
			return shipping_address_state;
		}
		public void setShipping_address_state(String shipping_address_state) {
			this.shipping_address_state = shipping_address_state;
		}
		public String getShipping_address_street1() {
			return shipping_address_street1;
		}
		public void setShipping_address_street1(String shipping_address_street1) {
			this.shipping_address_street1 = shipping_address_street1;
		}
		public String getShipping_address_street2() {
			return shipping_address_street2;
		}
		public void setShipping_address_street2(String shipping_address_street2) {
			this.shipping_address_street2 = shipping_address_street2;
		}
		public String getShipping_address_zipcode() {
			return shipping_address_zipcode;
		}
		public void setShipping_address_zipcode(String shipping_address_zipcode) {
			this.shipping_address_zipcode = shipping_address_zipcode;
		}
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
	    
	  

}
