package com.instahyre.instahyreproj.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instahyre.instahyreproj.dao.SpamReportRepository;
import com.instahyre.instahyreproj.entities.SpamReport;
import com.instahyre.instahyreproj.entities.User;

@Service
public class SpamServiceImpl implements SpamService {

    @Autowired
    private SpamReportRepository spamReportRepository;

    @Override
    public void markNumberAsSpam(User reporter, String reportedNumber) {
        // Your logic to mark a number as spam goes here
        List<SpamReport> existingReport = spamReportRepository.findByReporterAndReportedNumber(reporter, reportedNumber);
        if (existingReport == null) {
            SpamReport spamReport = new SpamReport();
            spamReport.setReporter(reporter);
            spamReport.setReportedNumber(reportedNumber);
            spamReportRepository.save(spamReport);
        }
    }

    @Override
    public int calculateSpamLikelihood(String phoneNumber) {
        // Your logic to calculate spam likelihood goes here
        // This is a placeholder, you might want to implement a more sophisticated algorithm
        List<SpamReport> reports = spamReportRepository.findByReportedNumber(phoneNumber);
        int credibility = 1; // Assign a credibility score to reporters
        return reports.size() * credibility;
    }
}
