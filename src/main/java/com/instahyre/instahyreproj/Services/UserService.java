package com.instahyre.instahyreproj.Services;

import java.util.List;
import java.util.Optional;

import com.instahyre.instahyreproj.entities.Contact;
import com.instahyre.instahyreproj.entities.User;

public interface UserService {
    User registerUser(User user);
    Optional<User> getUserById(Long userId);
    List<User> getAllUsers();
    void deleteUser(Long userId);
    List<User> searchByName(String name);
    Optional<User> searchByPhoneNumber(String phoneNumber);
    void markNumberAsSpam(User reporter, String phoneNumber);
    void addContact(Long userId, Contact contact);
    boolean existsByPhoneNumber(String phoneNumber);
    // Additional methods
    void save(User user);
}
