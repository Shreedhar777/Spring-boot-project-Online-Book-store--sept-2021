package com.book.store.bookstore.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.store.bookstore.Entity.BookOrder;

public interface OrderRepository extends JpaRepository<BookOrder,Integer> {

	List<BookOrder> findByCartId(int id);
   
}
