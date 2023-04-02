package com.example.n.Insurance.Management.Platform.Models;

import com.example.n.Insurance.Management.Platform.Enums.ClaimStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "claims")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String claimNumber;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate claimDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClaimStatus claimStatus;

    @ManyToOne
    @JoinColumn
    private InsurancePolicy policy;

    // constructors, getters, and setters

    public Claim() {

    }

    public Claim(Long id, String claimNumber, String description, LocalDate claimDate, ClaimStatus claimStatus, InsurancePolicy policy) {
        this.id = id;
        this.claimNumber = claimNumber;
        this.description = description;
        this.claimDate = claimDate;
        this.claimStatus = claimStatus;
        this.policy = policy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public ClaimStatus getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(ClaimStatus claimStatus) {
        this.claimStatus = claimStatus;
    }

    public InsurancePolicy getPolicy() {
        return policy;
    }

    public void setPolicy(InsurancePolicy policy) {
        this.policy = policy;
    }
}
