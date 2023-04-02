package com.example.n.Insurance.Management.Platform.Controllers;

import com.example.n.Insurance.Management.Platform.Models.InsurancePolicy;
import com.example.n.Insurance.Management.Platform.Services.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {

    @Autowired
    private InsurancePolicyService policyService;

    @GetMapping
    public ResponseEntity<List<InsurancePolicy>> getAllPolicies() {
        List<InsurancePolicy> policies = policyService.getAllPolicies();
        return new ResponseEntity<>(policies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsurancePolicy> getPolicyById(@PathVariable("id") Long id) {
        InsurancePolicy policy = policyService.getPolicyById(id);
        return new ResponseEntity<>(policy, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InsurancePolicy> createPolicy(@RequestBody InsurancePolicy policy) {
        InsurancePolicy createdPolicy = policyService.createPolicy(policy);
        return new ResponseEntity<>(createdPolicy, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsurancePolicy> updatePolicy(@PathVariable("id") Long id, @RequestBody InsurancePolicy policy) {
        InsurancePolicy updatedPolicy = policyService.updatePolicy(id, policy);
        return new ResponseEntity<>(updatedPolicy, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable("id") Long id) {
        policyService.deletePolicy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
