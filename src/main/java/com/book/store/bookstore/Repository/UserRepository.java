package com.book.store.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.store.bookstore.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmailAndSaltedPassword(String email,String saltedPassword);
}
