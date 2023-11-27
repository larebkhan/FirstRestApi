package com.instahyre.instahyreproj.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.instahyre.instahyreproj.Services.ContactService;
import com.instahyre.instahyreproj.Services.SpamService;

import com.instahyre.instahyreproj.dao.UserRepository;
import com.instahyre.instahyreproj.entities.SearchResultDTO;
import com.instahyre.instahyreproj.entities.User;

@RestController
@RequestMapping("/api/search")
public class SearchController {


    @Autowired
    private ContactService contactService;

    @Autowired
    private SpamService spamService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/byName")
    public ResponseEntity<List<SearchResultDTO>> searchByName(@RequestParam String query, @RequestParam Long userId) {
        List<SearchResultDTO> results = new ArrayList<>();

        // Search by name logic
        List<User> users = userRepository.findByNameContainingIgnoreCase(query);
        for (User user : users) {
            results.add(buildSearchResult(user, userId));
        }

        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping("/byPhoneNumber")
public ResponseEntity<List<SearchResultDTO>> searchByPhoneNumber(@RequestParam String query, @RequestParam Long userId) {
    List<SearchResultDTO> results = new ArrayList<>();

    // Search by phone number logic
    Optional<User> userOptional = userRepository.findByPhoneNumber(query); // Use the correct parameter 'query'
    userOptional.ifPresent(user -> results.add(buildSearchResult(user, userId)));

        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    private SearchResultDTO buildSearchResult(User user, Long searchingUserId) {
        SearchResultDTO result = new SearchResultDTO();
        result.setName(user.getName());
        result.setPhoneNumber(user.getPhoneNumber());
        result.setSpamLikelihood(spamService.calculateSpamLikelihood(user.getPhoneNumber()));
        
        if (user.getId().equals(searchingUserId)) {
            result.setEmail(user.getEmail());
        } else {
            // Check if the searching user is in the person's contact list
            Optional<User> searchingUser = userRepository.findById(searchingUserId);
            if (searchingUser.isPresent() && contactService.isContact(searchingUser.get(), user)) {
                result.setEmail(user.getEmail());
            }
        }

        return result;
    }
}
