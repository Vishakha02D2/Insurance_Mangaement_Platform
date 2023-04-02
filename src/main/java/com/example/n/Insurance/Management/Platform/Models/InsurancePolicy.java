package com.example.n.Insurance.Management.Platform.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "policies")
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String policyNumber;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private BigDecimal coverageAmount;

    @Column(nullable = false)
    private BigDecimal premium;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;


    @ManyToOne
    @JoinColumn
    private Client client;

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Claim> claims = new ArrayList<>();

    // constructors, getters, and setters

    public InsurancePolicy() {
    }

    public InsurancePolicy(Long id, String policyNumber, String type, BigDecimal coverageAmount, BigDecimal premium, LocalDate startDate, LocalDate endDate, Client client) {
        this.id = id;
        this.policyNumber = policyNumber;
        this.type = type;
        this.coverageAmount = coverageAmount;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(BigDecimal coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
