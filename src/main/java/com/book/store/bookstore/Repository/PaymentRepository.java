package com.book.store.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.store.bookstore.Entity.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

	
	Optional<Payment>  findByUserId(int id);

   
}
