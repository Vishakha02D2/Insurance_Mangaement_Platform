package com.example.n.Insurance.Management.Platform.Repositories;

import com.example.n.Insurance.Management.Platform.Models.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {
}
