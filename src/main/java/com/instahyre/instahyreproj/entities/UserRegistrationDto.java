package com.instahyre.instahyreproj.entities;

import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nonnull;

public class UserRegistrationDto {
    @Nonnull
    private String name;
    @Nonnull
    private String phoneNumber;
    private String email;
    private String password;

    // Constructors, getters, and setters

    public UserRegistrationDto() {
        // Default constructor
    }

    public UserRegistrationDto(String name, String phoneNumber, String email, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    // Getters and setters for each field

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString, hashCode, equals, if needed

    @Override
    public String toString() {
        return "UserRegistrationDto{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
