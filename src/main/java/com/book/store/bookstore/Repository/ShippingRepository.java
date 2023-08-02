package com.book.store.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.store.bookstore.Entity.Shipping;

import java.util.List;
import java.util.Optional;

public interface ShippingRepository extends JpaRepository<Shipping,Integer> {

	List<Shipping> findByUserId(int id);

}
