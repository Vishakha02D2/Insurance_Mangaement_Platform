package com.example.n.Insurance.Management.Platform.Repositories;

import com.example.n.Insurance.Management.Platform.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    //Client findByEmail(String email);
}
