package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserId(Long id);
}
