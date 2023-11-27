package com.instahyre.instahyreproj.entities;

public class SearchResultDTO {
    private String name;
    private String phoneNumber;
    private int spamLikelihood;
    private String email;


    
    public SearchResultDTO(String name, String phoneNumber, int spamLikelihood, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.spamLikelihood = spamLikelihood;
        this.email = email;
    }

    public SearchResultDTO() {
    }

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
    public int getSpamLikelihood() {
        return spamLikelihood;
    }
    public void setSpamLikelihood(int spamLikelihood) {
        this.spamLikelihood = spamLikelihood;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SearchResultDTO [name=" + name + ", phoneNumber=" + phoneNumber + ", spamLikelihood=" + spamLikelihood
                + ", email=" + email + "]";
    }
}
