package com.instahyre.instahyreproj.DataPopulation;

// package com.instahyre.instahyreproj.DataPopulation;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import com.instahyre.instahyreproj.Services.UserService;
// import com.instahyre.instahyreproj.entities.Contact;
// import com.instahyre.instahyreproj.entities.User;

// @Component
// public class DataPopulator implements CommandLineRunner {

//     @Autowired
//     private UserService userService;

//     @Override
//     public void run(String... args) throws Exception {
//         // Populate the database with sample data

//         // Sample Users
//         createUser("John Doe", "1234567890", "john.doe@example.com");
//         createUser("Jane Smith", "9876543210", "jane.smith@example.com");

//         // Sample Contacts
//         addContact("John Doe", "1112223333", "Friend 1");
//         addContact("John Doe", "4445556666", "Friend 2");

//         // Sample Spam Reports
//         markNumberAsSpam("John Doe", "5556667777");
//     }

//     private void createUser(String name, String phoneNumber, String email) {
//         User user = new User();
//         user.setName(name);
//         user.setPhoneNumber(phoneNumber);
//         user.setEmail(email);

//         try {
//             userService.registerUser(user);
//         } catch (IllegalArgumentException e) {
//             // Handle the exception, e.g., log an error message
//             System.err.println("Error registering user: " + e.getMessage());
//         }
//     }

//     private void addContact(String userName, String phoneNumber, String contactName) {
//         User user = userService.searchByPhoneNumber(phoneNumber).orElse(null);
//         if (user != null) {
//             Contact contact = new Contact();
//             contact.setUser(user);
//             contact.setName(contactName);
//             contact.setPhoneNumber(phoneNumber);
//             userService.addContact(user.getId(), contact);
//         } else {
//             System.err.println("User not found for phone number: " + phoneNumber);
//         }
//     }

//     private void markNumberAsSpam(String reporterName, String phoneNumber) {
//         User reporter = userService.searchByName(reporterName).stream().findFirst().orElse(null);
//         if (reporter != null) {
//             userService.markNumberAsSpam(reporter, phoneNumber);
//         } else {
//             System.err.println("Reporter not found with name: " + reporterName);
//         }
//     }
// }
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.instahyre.instahyreproj.Services.ContactService;
import com.instahyre.instahyreproj.Services.UserService;
import com.instahyre.instahyreproj.entities.Contact;
import com.instahyre.instahyreproj.entities.User;

import java.util.Random;


@Component
public class DataPopulator implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private ContactService contactService;

    @Override
    public void run(String... args) throws Exception {
        // Adjust these values based on your needs
        int numUsers = 20;
        int numContactsPerUser = 8;

        populateUsers(numUsers);
        populateContacts(numContactsPerUser, numUsers);
    }

    private void populateContacts(int numContactsPerUser, int numUsers) {
    }

    public void populateUsers(int numUsers) {
        for (int i = 0; i < numUsers; i++) {
            String phoneNumber = generateRandomPhoneNumber();

            // Ensure unique phone numbers
            while (userService.existsByPhoneNumber(phoneNumber)) {
                phoneNumber = generateRandomPhoneNumber();
            }

            User user = new User();
            user.setName(Faker.instance().name().fullName());
            user.setPhoneNumber(phoneNumber);

            // Set a secure random password
            String securePassword = generateRandomPassword();
            user.setPassword(passwordEncoder.encode(securePassword));

            // Optional: Add email address with a 50% chance
            if (new Random().nextBoolean()) {
                user.setEmail(Faker.instance().internet().emailAddress());
            }

            userService.save(user);
        }
    }

    private String generateRandomPhoneNumber() {
        // Generate a random 10-digit phone number
        StringBuilder phoneNumber = new StringBuilder("9"); // Indian phone number format
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }
    private String generateRandomPassword() {
        // Generate a random password
        return Faker.instance().internet().password();
    }
}
