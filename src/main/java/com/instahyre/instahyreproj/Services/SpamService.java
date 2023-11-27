package com.instahyre.instahyreproj.Services;

import com.instahyre.instahyreproj.entities.User;

public interface SpamService {
    void markNumberAsSpam(User reporter, String reportedNumber);
    int calculateSpamLikelihood(String phoneNumber);
    // Additional methods
}
