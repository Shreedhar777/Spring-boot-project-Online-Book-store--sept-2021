package com.book.store.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.store.bookstore.Entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Integer> {

	List<Cart> findByUserId(int id);
   
}
