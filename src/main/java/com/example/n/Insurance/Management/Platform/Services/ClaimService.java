package com.example.n.Insurance.Management.Platform.Services;

import com.example.n.Insurance.Management.Platform.Models.Claim;
import com.example.n.Insurance.Management.Platform.Repositories.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    public Claim getClaimById(Long id) {
        Optional<Claim> claim = claimRepository.findById(id);
        if (claim.isPresent()) {
            return claim.get();
        } else {
            throw new NoSuchElementException("Claim not found with id: " + id);
        }
    }

    public Claim createClaim(Claim claim) {
        return claimRepository.save(claim);
    }

    public Claim updateClaim(Long id, Claim updatedClaim) {
        Optional<Claim> claim = claimRepository.findById(id);
        if (claim.isPresent()) {
            Claim existingClaim = claim.get();
            existingClaim.setClaimNumber(updatedClaim.getClaimNumber());
            existingClaim.setDescription(updatedClaim.getDescription());
            //existingClaim.setClaimAmount(updatedClaim.getClaimAmount());
            existingClaim.setClaimDate(updatedClaim.getClaimDate());
            existingClaim.setPolicy(updatedClaim.getPolicy());
            return claimRepository.save(existingClaim);
        } else {
            throw new NoSuchElementException("Claim not found with id: " + id);
        }
    }

    public void deleteClaim(Long id) {
        Optional<Claim> claim = claimRepository.findById(id);
        if (claim.isPresent()) {
            claimRepository.delete(claim.get());
        } else {
            throw new NoSuchElementException("Claim not found with id: " + id);
        }
    }

}
