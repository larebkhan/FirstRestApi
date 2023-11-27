package com.instahyre.instahyreproj.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instahyre.instahyreproj.entities.Contact;
import com.instahyre.instahyreproj.entities.User;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByUser(User user);
    Optional<Contact> findByUserAndName(User user, String name);
    boolean existsByUserAndPhoneNumber(User user, String phoneNumber);
}
