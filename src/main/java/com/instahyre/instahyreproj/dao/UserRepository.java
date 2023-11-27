package com.instahyre.instahyreproj.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instahyre.instahyreproj.entities.User;

public interface UserRepository  extends JpaRepository<User, Long> {
    Optional<User> findByPhoneNumber(String phoneNumber);
    List<User> findByNameContainingIgnoreCase(String name);
    boolean existsByPhoneNumber(String phoneNumber);
}
