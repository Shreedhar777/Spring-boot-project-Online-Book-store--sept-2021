package com.book.store.bookstore.Entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;
    private String name;
    private String author;
    private String publication;
    private int availableQuantity;
    private long price;
    public Book(){}
    public Book(int id,String name,String author,String publication ,int availableQuantity, long price ){
        this.id=id;
        this.name=name;
        this.author=author;
        this.publication=publication;
        this.availableQuantity=availableQuantity;
        this.price=price;
    }
    public Book(String name,String author , String publication,int availableQuantity,long price){
        this.name=name;
        this.author=author;
        this.publication=publication;
        this.availableQuantity=availableQuantity;
        this.price=price;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
    
}
