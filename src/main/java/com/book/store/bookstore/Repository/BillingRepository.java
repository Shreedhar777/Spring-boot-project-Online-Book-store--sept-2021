package com.book.store.bookstore.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.store.bookstore.Entity.Billing;
import com.book.store.bookstore.Entity.Shipping;





public interface BillingRepository extends JpaRepository<Billing,Integer> {

	List<Billing> findByPaymentId(int id);
   
}
