package com.example.n.Insurance.Management.Platform.Services;

import com.example.n.Insurance.Management.Platform.Models.Client;
import com.example.n.Insurance.Management.Platform.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            return optionalClient.get();
        } else {
            throw new NoSuchElementException("Client not found with ID: " + id);
        }
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client existingClient = optionalClient.get();
            existingClient.setName(client.getName());
            existingClient.setDateOfBirth(client.getDateOfBirth());
            existingClient.setAddress(client.getAddress());
            existingClient.setContactInfo(client.getContactInfo());
            return clientRepository.save(existingClient);
        } else {
            throw new NoSuchElementException("Client not found with ID: " + id);
        }
    }

    public void deleteClient(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            clientRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Client not found with ID: " + id);
        }
    }
}
