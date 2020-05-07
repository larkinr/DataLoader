package com.Hastings.ATCMT.Models.Suites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "suite")
public class SuiteModel {

    private long testSuiteID;
    private String testSuiteName;
    private String description;


    public SuiteModel() {

    }

    public SuiteModel(String testSuiteName, String description) {
        this.testSuiteName = testSuiteName;
        this.description = description;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getTestSuiteID() { return testSuiteID; }

    public void setTestSuiteID(long testSuiteID) { this.testSuiteID = testSuiteID; }

    @Column(name = "testSuiteName", nullable = false)
    public String getSuiteName() { return testSuiteName; }

    public void setSuiteName(String suiteName) { this.testSuiteName = suiteName; }

    @Column(name = "description")
    public String getSuiteDescription() { return description; }

    public void setSuiteDescription(String description) { this.description = description; }

}
