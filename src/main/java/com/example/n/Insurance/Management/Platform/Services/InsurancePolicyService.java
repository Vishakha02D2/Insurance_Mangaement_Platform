package com.example.n.Insurance.Management.Platform.Services;

import com.example.n.Insurance.Management.Platform.Models.InsurancePolicy;
import com.example.n.Insurance.Management.Platform.Repositories.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class InsurancePolicyService {

    @Autowired
    private InsurancePolicyRepository policyRepository;

    public List<InsurancePolicy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public InsurancePolicy getPolicyById(Long id) {
        Optional<InsurancePolicy> policy = policyRepository.findById(id);
        if (policy.isPresent()) {
            return policy.get();
        } else {
            throw new NoSuchElementException("Policy not found with id: " + id);
        }
    }

    public InsurancePolicy createPolicy(InsurancePolicy policy) {
        return policyRepository.save(policy);
    }

    public InsurancePolicy updatePolicy(Long id, InsurancePolicy updatedPolicy) {
        Optional<InsurancePolicy> policy = policyRepository.findById(id);
        if (policy.isPresent()) {
            InsurancePolicy existingPolicy = policy.get();
            existingPolicy.setPolicyNumber(updatedPolicy.getPolicyNumber());
            existingPolicy.setType(updatedPolicy.getType());
            existingPolicy.setCoverageAmount(updatedPolicy.getCoverageAmount());
            existingPolicy.setPremium(updatedPolicy.getPremium());
            existingPolicy.setStartDate(updatedPolicy.getStartDate());
            existingPolicy.setEndDate(updatedPolicy.getEndDate());
            existingPolicy.setClient(updatedPolicy.getClient());
            return policyRepository.save(existingPolicy);
        } else {
            throw new NoSuchElementException("Policy not found with id: " + id);
        }
    }

    public void deletePolicy(Long id) {
        Optional<InsurancePolicy> policy = policyRepository.findById(id);
        if (policy.isPresent()) {
            policyRepository.delete(policy.get());
        } else {
            throw new NoSuchElementException("Policy not found with id: " + id);
        }
    }
}
