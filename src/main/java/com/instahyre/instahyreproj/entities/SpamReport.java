package com.instahyre.instahyreproj.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SpamReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User reporter;

    private String reportedNumber;

    public SpamReport(Long id, User reporter, String reportedNumber) {
        this.id = id;
        this.reporter = reporter;
        this.reportedNumber = reportedNumber;
    }

    public SpamReport() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public String getReportedNumber() {
        return reportedNumber;
    }

    public void setReportedNumber(String reportedNumber) {
        this.reportedNumber = reportedNumber;
    }

    

    @Override
    public String toString() {
        return "SpamReport [id=" + id + ", reporter=" + reporter + ", reportedNumber=" + reportedNumber + "]";
    }

    

    
}
