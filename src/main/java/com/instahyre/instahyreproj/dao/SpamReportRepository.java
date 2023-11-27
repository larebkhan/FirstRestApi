package com.instahyre.instahyreproj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instahyre.instahyreproj.entities.SpamReport;
import com.instahyre.instahyreproj.entities.User;

public interface SpamReportRepository extends JpaRepository<SpamReport, Long> {
    List<SpamReport> findByReportedNumber(String reportedNumber);
    List<SpamReport> findByReporterAndReportedNumber(User reporter, String reportedNumber);
}
