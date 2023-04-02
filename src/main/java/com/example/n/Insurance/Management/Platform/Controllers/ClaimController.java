package com.example.n.Insurance.Management.Platform.Controllers;

import com.example.n.Insurance.Management.Platform.Models.Claim;
import com.example.n.Insurance.Management.Platform.Services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping("")
    public List<Claim> getAllClaims() {
        return claimService.getAllClaims();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable Long id) {
        Claim claim = claimService.getClaimById(id);
        return new ResponseEntity<>(claim, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Claim> createClaim(@RequestBody Claim claim) {
        Claim createdClaim = claimService.createClaim(claim);
        return new ResponseEntity<>(createdClaim, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Claim> updateClaim(@PathVariable Long id, @RequestBody Claim updatedClaim) {
        Claim claim = claimService.updateClaim(id, updatedClaim);
        return new ResponseEntity<>(claim, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Long id) {
        claimService.deleteClaim(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

