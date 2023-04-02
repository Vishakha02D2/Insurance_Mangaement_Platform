package com.example.n.Insurance.Management.Platform.Repositories;

import com.example.n.Insurance.Management.Platform.Models.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
}
